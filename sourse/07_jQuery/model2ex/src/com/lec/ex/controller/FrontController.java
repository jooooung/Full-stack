package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.JoinService;
import com.lec.ex.service.MLoginService;
import com.lec.ex.service.MemailConfirmService;
import com.lec.ex.service.MidConfirmService;
import com.lec.ex.service.Service;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/main.do")) {
			viewPage = "main/main.jsp";
		}else if(command.equals("/joinView.do")) {  // 회원가입 페이지
			viewPage = "member/join.jsp";
		}else if(command.equals("/midConfirm.do")) {  // 아이디 중복체크
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/midConfirm.jsp";
		}else if(command.equals("/memailConfirm.do")) {  // 이메일 중복체크
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/memailConfirm.jsp";
		}else if(command.equals("/join.do")) {  // 회원가입 처리   
			service = new JoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(command.equals("/loginView.do")) {	//로그인 페이지
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) {	// 로그인 처리
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main.do";
		}else if(command.equals("/adminLoginView.do")) {	// 관리자 로그인 페이지
			viewPage = "member/adminLogin.jsp";
		}
		/* * * * * * * member 관련 요청	* * * * * * */
		/* * * * * * * admin관련 요청	* * * * * * */
		/* * * * * * * 파일첨부 게시판  관련 요청	* * * * * * */
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
