package com.lec.prac.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.prac.dto.Board;

public interface BoardService {
	public List<Board> list(String pageNum);
	public int totCnt();
	public Board detail(int bid);
	public int write(Board board, HttpServletRequest request);
	public int reply(Board board, HttpServletRequest request);
	public int modify(Board board, HttpServletRequest request);
	public int delete(int bid);
}
