package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href=\"css/quiz1.css\" rel=\"stylesheet\"");
		out.println("</head>");
		out.println("<body>");
		for(int i=0 ; i<su.length ; i++) {
			out.println("<h3>" + su[i] + "단</h3>");
				for(int j=1 ; j<=9 ; j++) {
					int dansu = Integer.parseInt(su[i]);
					out.printf("<p>%d * %d = %d</p>", dansu, j, dansu * j);
			}
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
