package com.lec.ch17.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch15.utill.Paging;
import com.lec.ch17.dao.BoardDao;
import com.lec.ch17.dto.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> list(String pageNum) {
		Paging paging = new Paging(boardDao.totCnt(), pageNum, 10, 10);
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.list(board);
	}

	@Override
	public int totCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int write(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hitUp(int bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board detail(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int preReply(int bgroup) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board reply(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}
