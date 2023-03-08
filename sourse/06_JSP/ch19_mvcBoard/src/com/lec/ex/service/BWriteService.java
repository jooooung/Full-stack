package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BWriteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// bname, btitle, bcontent 파라미터 받고 bip 가져와서 db에 write
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();
		BoardDao bDao = new BoardDao();
		request.setAttribute("writeResult", bDao.write(bname, btitle, bcontent, bip));
	}
}
