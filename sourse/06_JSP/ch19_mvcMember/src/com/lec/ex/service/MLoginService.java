package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MLoginService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = new MemberDao();
		MemberDto member = (MemberDto)session.getAttribute("member");
		int result = mDao.loginChk(mid, mpw);
		if(result == MemberDao.SUCCESS) {
			session.setAttribute("member", member);
			request.setAttribute("loginResult", result);
		}else {
			
		}
	}
}
