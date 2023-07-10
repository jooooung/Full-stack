package com.lec.prac.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.prac.dao.BoardDao;
import com.lec.prac.dto.Board;
import com.lec.prac.utill.Paging;

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
		return boardDao.totCnt();
	}

	@Override
	public Board detail(int bid) {
		boardDao.hitUp(bid);
		return boardDao.detail(bid);
	}

	@Override
	public int write(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardDao.write(board);
	}

	@Override
	public int reply(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		boardDao.preReply(board);
		return boardDao.reply(board);
	}

	@Override
	public int modify(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardDao.modify(board);
	}

	@Override
	public int delete(int bid) {
		return boardDao.delete(bid);
	}
}
