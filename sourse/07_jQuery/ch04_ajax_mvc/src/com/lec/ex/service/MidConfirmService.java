package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.service.Service;

public class MidConfirmService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDao mDao = new MemberDao();
		int result = mDao.midConfirm(mid);
		if(result == MemberDao.FAIL){
			request.setAttribute("midConfirmResult", "중복된 ID입니다");
		}else{
			request.setAttribute("midConfirmResult", "사용가능한 ID입니다");
		}
	}
}
