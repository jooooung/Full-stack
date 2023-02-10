package com.lec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MVC 패턴에서 컨트롤러 역할을 하는 서블릿
@WebServlet("*.do")	// .do로 끝나는 모든 것으로 URL mapping
public class Ex3_mvc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청된 command(writer.do, join.do, memberLogin.do, delete.do)
		// uri : /ch05_JSP/delete.do
		// conPath : /ch05_JSP
		String conPath = request.getContextPath();
		String uri = request.getRequestURI();	
		String command = uri.substring(conPath.length()+1);
		System.out.println("conPath : " + conPath);		
		System.out.println("uri : " + uri);		
		System.out.println("command  : " + command );		
		response.setContentType("text.html; charset=utf-8");
		response.getWriter().println("conPath : " + conPath);
		response.getWriter().println("uri : " + uri);
		response.getWriter().println("command  : " + command);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
