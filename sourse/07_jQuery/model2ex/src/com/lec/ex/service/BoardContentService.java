package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.FileboardDao;
import com.lec.ex.dto.FIleboardDto;

public class BoardContentService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileboardDao fDao = FileboardDao.getinstance();
		FIleboardDto fDto = fDao.getFileboardOne(fid);
		request.setAttribute("board", fDto);
	}
}
