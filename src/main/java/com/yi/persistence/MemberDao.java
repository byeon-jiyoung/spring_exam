package com.yi.persistence;

import com.yi.domain.MemberVO;

public interface MemberDao {
	
	public void insertMember(MemberVO vo) throws Exception;
	public MemberVO selectMemberById(String userid) throws Exception;
}
