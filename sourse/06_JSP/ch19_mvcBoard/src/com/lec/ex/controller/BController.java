package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.*;

@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int writeView = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri 		= request.getRequestURI();
		String conPath  = request.getContextPath();
		String command  = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/list.do")) { // 글목록
			service = new BListService();
			service.execute(request, response);		// BListService에 있는 execute 호출
			viewPage = "board/list.jsp";
		}else if(command.equals("/writeView.do")) { // 글쓰기
			viewPage = "board/write_view.jsp";
			writeView = 1;
		}else if(command.equals("/write.do")) {	// 글쓰기 DB에 저장
			if(writeView == 1) {
				service = new BWriteService();
				service.execute(request, response);
				writeView = 0;
			}
			viewPage = "list.do";
		}else if(command.equals("/contentView.do")) {  // 상세보기
			service = new BContentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
		}else if(command.equals("/modifyView.do")) {	// 글 수정
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "board/modify_view.jsp"; // requestScope.modifyBoard, param.bid, param.pageNum
		}else if(command.equals("/modify.do")) {	// 수정 글 저장
				service = new BmodifyService();
				service.execute(request, response);
//				viewPage = "list.do";	// 수정 후 목록으로 requestScope.modifyResult, param.pageNum...
				viewPage = "contentView.do";  // 수정 후 상세보기
		}else if(command.equals("/delete.do")) {  // 글삭제
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/replyView.do")) {	// 답글
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "board/reply_view.jsp"; // param.pageNum, requestScope.replyBoard(원글정보)
			writeView = 1;
		}else if(command.equals("/reply.do")) {  // 답글 DB에 저장
			if(writeView == 1) {
				service = new BReplyService();
				service.execute(request, response);
				writeView = 0;
			}
			viewPage = "list.do";	// param.pageNum, param.bid, requestScope.replyResult
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
