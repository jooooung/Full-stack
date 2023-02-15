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
	<jsp:useBean id="s" class="com.lec.ex.Student" scope="request"/>
	<h2>입력받은 학생 정보</h2>
	<p>학번 : <%=s.getID() %></p>
	<p>이름 : <%=s.getName() %></p>
	<p>학년 : <%=s.getGrade() %></p>
	<p>빈 : <%=s.getCls() %></p>
	<p>점수 : <%=s.getScore() %></p>
</body>
</html>