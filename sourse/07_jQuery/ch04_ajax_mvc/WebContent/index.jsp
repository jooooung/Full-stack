<%@page import="java.net.URLEncoder"%>
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
	// String name = URLEncoder.encode("공책", "utf-8");
	// response.sendRedirect("productStock.do?pname="+name);
	// response.sendRedirect("productView.do");
	// response.sendRedirect("midConfirm.do?mid=aaaa");
	response.sendRedirect("joinView.do");
%>
</body>
</html>