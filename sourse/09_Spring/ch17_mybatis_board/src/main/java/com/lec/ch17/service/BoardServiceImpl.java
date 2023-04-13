package com.lec.ch17.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch17.dao.BoardDao;
import com.lec.ch17.dto.Board;
import com.lec.ch17.utill.Paging;
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
	public int write(Board board) {
		return boardDao.write(board);
	}

	@Override
	public int hitUp(int bid) {
		return boardDao.hitUp(bid);
	}

	@Override
	public Board detail(int bid) {
		return boardDao.detail(bid);
	}

	@Override
	public int modify(Board board) {
		return boardDao.modify(board);
	}

	@Override
	public int delete(int bid) {
		return boardDao.delete(bid);
	}

	@Override
	public int preReply(int bgroup) {
		return boardDao.preReply(bgroup);
	}

	@Override
	public Board reply(Board board) {
		return boardDao.reply(board);
	}
}
