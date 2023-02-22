<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.insertBoard(dto);
		if(result == BoardDao.SUCCESS){
	%>
			<script>
				location.href='list.jsp';
			</script>
	<%}else{%>
			<script>
				history.go(-1);
			</script>
	<%} %>
</body>
</html>