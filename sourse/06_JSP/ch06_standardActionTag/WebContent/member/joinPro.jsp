<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
</head>
<body>
	<%
	response.setContentType("text/html; charset=utf-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	Date birth = Date.valueOf(request.getParameter("birth"));
	Date birth2 = Date.valueOf(request.getParameter("birth"));
	Timestamp birthTimestamp = Timestamp.valueOf(request.getParameter("birth")+" 00:00:00");
	String[] hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");
	String ip = request.getRemoteAddr();
	Date date = new Date(System.currentTimeMillis());
	out.println("<html>");
	out.println("<body>");
	out.println("<div id='joinForm_wrap'>");
	out.println("<div id='join_title'>회원가입정보</div>");
	out.println("<h2>name : " + name + "</h2>");
	out.println("<h2>id : " + id + "</h2>");
	out.println("<h2>pw : " + pw.replaceAll("[a-zA-Z0-9~`!@#$%^&*()\\-_+=|\\{}\\[\\]:;\"'?/<>,\\.]", "*") + "</h2>");
	out.println("<h2>birth : "+birth2+"</h2>");
	out.println("<h2>birth2 : "+birthTimestamp+"</h2>");
	out.println("<h2>hobby : ");
	if(hobby!=null) {
		for(int i=0 ; i<hobby.length ; i++)
			if(i==hobby.length-1){
				out.print(hobby[i]);
			}else
				out.print(hobby[i]+", ");
	}else {
		out.print("없음");
	}
	out.println("</h2>");
	out.println("<h2>");
	out.println("<h2>gender : "+gender + "</h2>");
	out.println("<h2>email : "+email + "</h2>");
	out.println("<h2>mailSend : ");
	if(mailSend!=null) {
		out.print(Arrays.toString(mailSend) + "</h2>");
	}else {
		out.print("모두 거부</h2>");
	}
	out.println("<h2>가입일 : "+date + "</h2>");
	out.println("<h2>가입ip : "+ip + "</h2>");
	out.println("</h2>");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	%>
</body>
</html>