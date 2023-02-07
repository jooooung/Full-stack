package com.lec.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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
		//같은 이름의 파라미터 전달 받았을 때 (menu, rest)
		String[] menu = request.getParameterValues("menu");		// 배열로 받는다
		String[] rest = request.getParameterValues("rest");		// 배열로 받는다
		String nation = request.getParameter("nation");		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		if(menu!=null) {
			out.println("<h2>선택한 메뉴는 " + Arrays.toString(menu) + "<h2>");
		}else {
			out.println("<h2>선택한 메뉴가 없습니다</h2>");
		}
		if(rest!=null) {
			out.println("<h2>선택한 식당 " + Arrays.toString(rest) + "<h2>");
		}else {
			out.println("<h2>선택한 식당 없습니다</h2>");
		}
		if(nation!=null) {
			out.println("<h2>선택한 국적  " + nation + "<h2>");
		}else {
			out.println("<h2>선택한 국적 없습니다</h2>");
		}
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
