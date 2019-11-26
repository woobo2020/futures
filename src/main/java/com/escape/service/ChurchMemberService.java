package com.escape.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escape.dao.ChurchMemberMapper;
import com.escape.domain.ChurchMember;

@Service
public class ChurchMemberService {

	
	@Autowired
	private ChurchMemberMapper mapper;
	
	public List<ChurchMember> getChurchMemberList(Map<String, Object> param){
		return mapper.getChurchMemberList(param);
	}
	
	public int getChurchMemberCnt() {
		return mapper.getChurchMemberCnt();
	}
	
}
