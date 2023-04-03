package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.FileboardDao;

public class BoardDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileboardDao fDao = FileboardDao.getinstance();
		int result = fDao.delete(fid);
		String deleteResult = result==FileboardDao.SUCCESS? "삭제 성공" : "삭제 실패";
		request.setAttribute("deleteResult", deleteResult);
	}
}
