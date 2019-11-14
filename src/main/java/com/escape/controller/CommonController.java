package com.escape.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommonController {

	@RequestMapping(value = "/churchlist.do", method = RequestMethod.GET)
	public ModelAndView getChurchList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("churchlist2");
		Random random = new Random();
		Map<String,String> item = null;
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for (int i =0; i < 10 ; i++) {
			item = new HashMap<String, String>();
			item.put("first", String.valueOf(random.nextInt()));
			item.put("second", String.valueOf(random.nextInt()));
			item.put("third", String.valueOf(random.nextInt()));
			list.add(item);
		}
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/churchlist2.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getChurchList2(HttpServletRequest request, HttpServletResponse response) {
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
