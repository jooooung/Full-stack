package com.lec.ch17.service;

import java.util.List;

import com.lec.ch17.dto.Board;

public interface BoardService {
	public List<Board> list(String pageNum);
	public int totCnt();
	public int write(Board board);
	public int hitUp(int bid);
	public Board detail(int bid);
	public int modify(Board board); 
	public int delete(int bid);
	public int preReply(int bgroup);
	public Board reply(Board board);
}
