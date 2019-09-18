package com.yi.service;

import com.yi.domain.MemberVO;

public interface MemberService {
	
	public void insertMember(MemberVO vo) throws Exception;
	public MemberVO selectMemberById(String userid) throws Exception;
}
