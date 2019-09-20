package com.yi.persistence;

import java.util.List;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

public interface BoardDao {
	
	public void insertBoard(BoardVO vo) throws Exception;
	public List<BoardVO> listboard(Criteria cri) throws Exception;
	public int listBoardCount(Criteria cri) throws Exception;
	public BoardVO readBoard(int bno) throws Exception;
	public void deleteBoard(int bno) throws Exception;
}
