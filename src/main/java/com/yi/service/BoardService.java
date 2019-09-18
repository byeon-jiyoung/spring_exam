package com.yi.service;

import java.util.List;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

public interface BoardService {
	
	public void insertBoard(BoardVO vo) throws Exception;
	public List<BoardVO> listboard(Criteria cri) throws Exception;
	public int listboardCount(Criteria cri) throws Exception;
	
}
