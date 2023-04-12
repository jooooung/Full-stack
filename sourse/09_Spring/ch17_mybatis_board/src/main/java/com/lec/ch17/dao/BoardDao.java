package com.lec.ch17.dao;


import java.util.List;

import com.lec.ch17.dto.Board;

public interface BoardDao {
	public List<Board> list(Board board);
}
