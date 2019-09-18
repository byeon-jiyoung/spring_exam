package com.yi.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	private static final String namespace = "com.yi.mapper.MemberMapper";
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		sqlsession.insert(namespace + ".insertMember", vo);
	}

	@Override
	public MemberVO selectMemberById(String userid) throws Exception {
		return sqlsession.selectOne(namespace + ".selectMemberById", userid);
	}

}
