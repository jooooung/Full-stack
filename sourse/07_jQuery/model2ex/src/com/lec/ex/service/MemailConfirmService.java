package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MemailConfirmService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mDao = new MemberDao();
		int result = mDao.mEmailConfirm(memail);
		if(result == MemberDao.FAIL){
			request.setAttribute("memailConfirmResult", "<b>중복된 이메일입니다</b>");
		}else{
			request.setAttribute("memailConfirmResult", "사용가능한 이메일입니다");
		}
	}
}
