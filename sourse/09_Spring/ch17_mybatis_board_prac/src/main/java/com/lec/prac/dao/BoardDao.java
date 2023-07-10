package com.lec.prac.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.prac.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> list(Board board);
	public int totCnt();
	public Board detail(int bid);
	public int hitUp(int bid);
	public int write(Board board);
	public int preReply(Board board);
	public int reply(Board board);
	public int modify(Board board);
	public int delete(int bid);
}
