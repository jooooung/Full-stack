package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.FileboardDao;
import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MWithdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = null;
		MemberDto sessionMember = (MemberDto) session.getAttribute("member");	// 세션 member 가져오기 
		if(sessionMember != null) {
			mid = sessionMember.getMid();
		}
		FileboardDao fDao = FileboardDao.getinstance();
		int WithdrawalDelete = fDao.WithdrawalDelete(mid);	// 탈퇴 회원 글 삭제
		MemberDao mDao = new MemberDao();
		int result = mDao.withdrawalMember(mid);	// 회원탈퇴
		session.invalidate();
		if(result == MemberDao.SUCCESS) {
			request.setAttribute("withdrawalResult", "회원 탈퇴가 완료되었습니다.");
		}else {
			request.setAttribute("withdrawalResult", "로그인 상태가 아닙니다.");
		}
	}
}
