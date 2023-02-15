<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!-- process단 -->
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<jsp:setProperty name="p" property="name" 	 value='<%=request.getParameter("name") %>'/>	
	<jsp:setProperty name="p" property="age" 	   value='<%=request.getParameter("age") %>'/>	
	<jsp:setProperty name="p" property="gender"  value='<%=request.getParameter("gender") %>'/>	
	<jsp:setProperty name="p" property="address" value='<%=request.getParameter("address") %>'/>	
	<jsp:forward page="personView.jsp"/>	<!-- 주소창 변화 없이 페이지 이동 -->
</body>
</html>