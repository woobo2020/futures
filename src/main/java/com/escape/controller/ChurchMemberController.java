package com.escape.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.escape.common.Pager;
import com.escape.domain.ChurchMember;
import com.escape.service.ChurchMemberService;
import com.escape.util.CommonUtil;

@RestController
public class ChurchMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChurchMemberController.class);
	
	@Autowired
	private ChurchMemberService churchMemberService;
	
	@RequestMapping(value = "church/churchMemberList.do", method = RequestMethod.GET)
	public ModelAndView getChurchMemberList(HttpServletRequest request, HttpServletResponse response) {
		final ModelAndView mav = new ModelAndView("church/churchMemberList");
		return mav;
	}
	
	@RequestMapping(value = "church/churchMemberListTpl.do", method = RequestMethod.POST)
	public ModelAndView getChurchMemberListTpl(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("SEARCH CHURCH MEMBER LIST START...");
		
		int curPageNum = Integer.parseInt(CommonUtil.ckNullStr((String) request.getParameter("curPageNum"), "1"));
		int recordsPerPage = Integer.parseInt(CommonUtil.ckNullStr(request.getParameter("lines"),"20"));
		
		final Map<String, Object> param = new HashMap<String, Object>();
		
		int totalCnt = churchMemberService.getChurchMemberCnt();
		
		Pager pager = new Pager(totalCnt, curPageNum,recordsPerPage, 10);
		if (pager.totalPage < curPageNum) {
			curPageNum = 1;
			pager = new Pager(totalCnt, curPageNum, recordsPerPage,10);
		}
		param.put("offset", pager.startItem-1);
		param.put("limit", recordsPerPage);
		
		final List<ChurchMember> churchMemberList = churchMemberService.getChurchMemberList(param);
		if(churchMemberList != null && churchMemberList.size() > 0) {
			for (ChurchMember churchMember : churchMemberList) {
				logger.debug("{}-{}",churchMember.getChurch_name(),churchMember.getName());
			}
		}

		final ModelAndView mav = new ModelAndView("church/churchMemberListTpl");	
		mav.addObject("list", churchMemberList);
		mav.addObject("totalCnt", String.valueOf(totalCnt));
		mav.addObject("pager",pager);
		
		logger.info("SEARCH CHURCH MEMBER LIST FINISHED...");
		return mav;
	}
	
	@RequestMapping(value="/churchlist3.do",method=RequestMethod.GET)
	@ResponseBody
	public JSONArray LinqGridData(HttpServletRequest request, HttpServletResponse response) {
		
		final String name = request.getParameter("names");
		final String age = request.getParameter("ages");
		
		logger.debug("NAME="+name +",AGE="+age+"#######################");
		
		
		JSONObject item = new JSONObject();
		
		JSONArray list = new JSONArray();
		
		Random random = new Random();
		for (int i =0; i < 10 ; i++) {
			item = new JSONObject();
			item.put("OrderID", String.valueOf(random.nextInt()));
			item.put("CustomerID", String.valueOf(random.nextInt()));
			item.put("OrderDate", String.valueOf(random.nextInt()));
			item.put("Freight", String.valueOf(random.nextInt()));
			item.put("ShipName", String.valueOf(random.nextInt()));
			list.add(item);
		}
		return list;
	}

	@RequestMapping(value="/churchlist2.do",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getChurchList2(HttpServletRequest request, HttpServletResponse response) {
		
		final String name = request.getParameter("names");
		final String age = request.getParameter("ages");
		
		System.out.println("NAME="+name +",AGE="+age);
		
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		Random random = new Random();
		Map<String,Object> item = null;
		for (int i =0; i < 10 ; i++) {
			item = new HashMap<String, Object>();
			item.put("OrderID", String.valueOf(random.nextInt()));
			item.put("CustomerID", String.valueOf(random.nextInt()));
			item.put("OrderDate", String.valueOf(random.nextInt()));
			item.put("Freight", String.valueOf(random.nextInt()));
			item.put("ShipName", String.valueOf(random.nextInt()));
			result.add(item);
		}
		return result;
	}
}
