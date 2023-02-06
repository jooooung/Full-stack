<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		Date now = new Date();
		String str = String.format("%1$TY년 %1$Tm월 %1$Td일", now);
		GregorianCalendar now2 = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String str2 = sdf.format(now2.getTime());
	%>
	<p>String.format = str : <%=str %></p>
	<p>sdf.format = str2 : <%=str2 %></p>
	<hr>
	<%@ include file="1_hello.jsp" %> 
</body>
</html>