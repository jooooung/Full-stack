package com.lec.ex.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.FileboardDao;

public class BoardModifyViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileboardDao fDao = FileboardDao.getinstance();
		request.setAttribute("modifyBoard", fDao.modyfyView_replyView(fid));
	}
}
