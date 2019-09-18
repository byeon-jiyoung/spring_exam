package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String namespace = "com.yi.mapper.BoardMapper";
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		sqlsession.insert(namespace + ".insertBoard", vo);
	}

	@Override
	public List<BoardVO> listboard(Criteria cri) throws Exception {
		return sqlsession.selectList(namespace + ".listboard", cri);
	}

	@Override
	public int listboardCount(Criteria cri) throws Exception {
		return sqlsession.selectOne(namespace + ".listboardCount", cri);
	}

}
