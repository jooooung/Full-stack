package com.lec.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.*;

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
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("<h1>FrontController</h1>");
		// 들어온 요청 판별(insert.do?, select.do?, update.do?, delete.do?) 후 수행, view 로 forward
		// uri : /ch18/insert.do
		String uri = request.getRequestURI();
		// conPath : /ch18
		String conPath = request.getContextPath();
		// command : /insert.do
		String command = uri.substring(conPath.length());
		response.getWriter().append(command);
		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("command : " + command);
		// 들어온 요청에 따라 다른 일을 하고 뷰로 forward
		String viewPage = null; // 뷰페이지를 저장할 변수
		Service service = null; // InsertService, SelectService, DeleteService, UpdateService 객체 지정 
		if(command.equals("/insert.do")) {
			service = new InsertService();
			service.execute(request, response);
			viewPage = "select.do";
		}else if(command.equals("/select.do")) {
			service = new SelectService();
			service.execute(request, response);
			viewPage = "ex2/select.jsp";
		}else if(command.equals("/update.do")) {
			service = new UpdateService();
			service.execute(request, response);
			viewPage = "select.do";
		}else if(command.equals("/delete.do")) {
			service = new DeleteService();
			service.execute(request, response);
			viewPage = "select.do";
		}
		// viewPage로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
