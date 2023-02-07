package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int num = Integer.parseInt(numStr);
		out.println("<html>");
		out.println("<head>");
		out.println("<link href=\"/ch03_semiServlet/css/ex2.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
		out.println(num + "단 구구단");
		for(int i=1 ; i<=9 ; i++) {
			out.printf("<p>%d * %d = %d</p>", num, i, num*i);
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
