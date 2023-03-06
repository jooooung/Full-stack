package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex2_suPro")
public class Ex2_suPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 프로세스는 자바에서
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0;
		for(int i=1 ; i<=su ; i++) {
			sum += i;
		}
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>");
//		out.print("1부터" + su + "까지 누적합 : " + sum);
//		out.print("</body></html>");
//		out.close();
		request.setAttribute("sum", sum);	// request에 sum 추가
		// 뷰단으로 포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex2_suView.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
}
