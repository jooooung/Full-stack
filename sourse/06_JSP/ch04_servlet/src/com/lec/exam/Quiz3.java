package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz3")
public class Quiz3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String suStr = request.getParameter("su");
		int su = Integer.parseInt(suStr);
		int sum =0;
		for(int i = 1 ; i<=su  ; i++) {
			sum += i;
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<link href=\"/ch04_servlet/css/quiz3.css\" rel=\"stylesheet\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<p>1부터 " + su + "까지 누적합은 " + sum + "</p>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
