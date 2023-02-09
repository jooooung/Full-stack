package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz4")
public class Quiz4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String[] colorSet = {"red","orange", "yellow", "green", "blue", "navy", "violet"};
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bgColor = request.getParameter("color");
		String fontColor = request.getParameter("color");
		int idx;
		for(idx=0; idx<colorSet.length ; idx++) {
			if(colorSet[idx].equals(bgColor)){
				break;
			}
		}
		int fontIdx = (idx==0) ? 6 : idx-1;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body { background-color:" + bgColor +";}");
		out.println("body { color:" + colorSet[fontIdx]+";}");
		out.println("</style>");
		out.println("</head>");
		out.print("<body>");
		out.print("<h1>GET방식 요청입니다</h1>");
		out.print("<h1>글자색은" + bgColor + "배경색은 " + colorSet[fontIdx] +  "입니다</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int colorIdx = Integer.parseInt(request.getParameter("colorIdx"));
		int fontColorIdx = colorIdx==0? 6 : colorIdx-1;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body { background-color:" + colorSet[colorIdx] +";}");
		out.println("body { color:" + colorSet[fontColorIdx] +";}");
		out.println("</style>");
		out.println("</head>");
		out.print("<body>");
		out.print("<h1>POST방식 요청입니다</h1>");
		out.print("<h1>글자색은 " + colorSet[fontColorIdx] + "배경색은 " + colorSet[colorIdx] + "입니다</h1>" );
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
