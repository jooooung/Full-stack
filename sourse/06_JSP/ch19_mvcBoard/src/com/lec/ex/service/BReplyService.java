package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BReplyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파일 첨부시 멀티파트리퀘스트
		String bname 	= request.getParameter("bname");
		String btitle   = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip  = request.getRemoteAddr();
		int bgroup  = Integer.parseInt(request.getParameter("bgroup")); // 원글
		int bstep   = Integer.parseInt(request.getParameter("bstep"));	// 원글
		int bindent = Integer.parseInt(request.getParameter("bindent"));// 원글
		BoardDao bDao = new BoardDao();
		request.setAttribute("replyResult", bDao.reply(bname, btitle, bcontent, bip, bgroup, bstep, bindent)); 
	}
}
