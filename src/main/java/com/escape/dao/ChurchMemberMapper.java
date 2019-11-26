package com.escape.dao;

import java.util.List;
import java.util.Map;

import com.escape.domain.ChurchMember;

public interface ChurchMemberMapper {
	
	List<ChurchMember> getChurchMemberList(Map<String, Object> param);
	
	int getChurchMemberCnt();

}
