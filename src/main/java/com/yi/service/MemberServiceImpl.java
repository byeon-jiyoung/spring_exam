package com.yi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.MemberVO;
import com.yi.persistence.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;

	@Override
	public void insertMember(MemberVO vo) throws Exception {
		dao.insertMember(vo);
	}

	@Override
	public MemberVO selectMemberById(String userid) throws Exception {
		return dao.selectMemberById(userid);
	}

	@Override
	public MemberVO selectMemberByIdAndPw(String userid, String userpw) throws Exception {
		return dao.selectMemberByIdAndPw(userid, userpw);
	}
}
