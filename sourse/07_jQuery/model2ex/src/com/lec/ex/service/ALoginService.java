package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.AdminDao;
import com.lec.ex.dto.AdminDto;

public class ALoginService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao aDao = AdminDao.getinstance();
		int result = aDao.loginChk(aid, apw);
		if(result == AdminDao.SUCCESS) {
			HttpSession session = request.getSession();
			AdminDto admin = aDao.getAdmin(aid);
			session.setAttribute("admin", admin);
			request.setAttribute("adminLoginResult", "관리자 계정으로 들어오셨습니다");
		}else {
			request.setAttribute("adminLoginErrorMsg", "관리자 계정으로 로그인이 실패했습니다");
		}
	}
}
