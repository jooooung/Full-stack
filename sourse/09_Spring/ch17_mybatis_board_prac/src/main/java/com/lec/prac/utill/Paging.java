package com.lec.prac.utill;

import lombok.Data;

@Data
public class Paging {
	private int currentPage = 1;
	private int pageSize;
	private int blockSize;
	private int startRow;
	private int endRow;
	private int totCnt;
	private int pageCnt;
	private int startPage;
	private int endPage;
	
	public Paging(int totCnt, String pageNum, int pageSize, int blockSize) {
		if(pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		this.totCnt = totCnt;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		startRow = (currentPage - 1) * pageSize + 1;
		endRow    = startRow + pageSize - 1;
		pageCnt   = (int)Math.ceil((double)totCnt/pageSize);
		startPage = ((currentPage-1) / blockSize ) * blockSize + 1;
		endPage   = startPage + blockSize - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
	}
}
