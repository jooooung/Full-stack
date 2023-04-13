package com.lec.ch17.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.dto.Board;
@Mapper
public interface BoardDao {
	public List<Board> list(Board board);
	public int totCnt();
	public int write(Board board);
	public int hitUp(int bid);
	public Board detail(int bid);
	public int modify(Board board); 
	public int delete(int bid);
	public int preReply(Board board);
	public int reply(Board board);
}
