package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");	// 파라미터로 num 가져오기
		response.setContentType("text/html; charset=utf-8");	
		if(numStr == null) {
			response.getWriter().print("넘어온 파라미터가 없습니다");
		} else {
			int num = Integer.parseInt(numStr);	// 가져온 파라미터 형변환
			int sum = 0;
			for(int i=0 ; i<=num ; i++) {	// 누적합
				sum += i;
			}
			
			PrintWriter out = response.getWriter();	// 스트림 생성
			out.print("<html>");
			out.print("<head>");
			out.print("<link href=\"/ch03_semiServlet/css/ex2.css\" rel=\"stylesheet\">");	// css 연결
			out.print("</head>");
			out.print("<body>");
			out.print("<h2>1부터"+num+"까지 누적합은" + sum +"입니다</h2>");
			out.print("</body>");
			out.print("</html>");
			out.close();	// 스트림 닫기
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
