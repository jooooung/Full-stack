package com.lec.ch12.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;

public class BListService implements Service {
	@Override
	public void execute(Model model) {
		// pageNum 가져오기
		Map<String, Object> map = model.asMap(); // model을 map으로 변경
		  // 키값            value
		// model.addattribute("pageNum", null);
		String pageNum = (String) map.get("pageNum");
		if(pageNum == null) pageNum = "1";
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage -1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BoardDao bDao = new BoardDao();
		// 출력될 board list
		model.addAttribute("boardList", bDao.list(startRow, endRow));
		int orderNum = startRow;  // 출력될 순차번호
		int totCnt = bDao.getBoardTotCnt();  // 전체 글개수 
		int inverseNum = totCnt - startRow + 1; // 출력될 역순 번호
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1) / BLOCKSIZE) * BLOCKSIZE + 1; 
//		int startPage = currentPage - (currentPage-1) / BLOCKSIZE;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt) endPage = pageCnt;
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		model.addAttribute("pageNum", currentPage);
	}
}
