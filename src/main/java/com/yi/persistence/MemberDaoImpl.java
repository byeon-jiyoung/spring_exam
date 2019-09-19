package com.yi.persistence;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public MemberVO selectMemberByIdAndPw(String userid, String userpw) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		
		return sqlsession.selectOne(namespace + ".selectMemberByIdAndPw", map);
	}

}
