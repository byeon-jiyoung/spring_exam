package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao;
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		
		dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> listboard(Criteria cri) throws Exception {
		return dao.listboard(cri);
	}

	@Override
	public int listboardCount(Criteria cri) throws Exception {
		return dao.listboardCount(cri);
	}

}
