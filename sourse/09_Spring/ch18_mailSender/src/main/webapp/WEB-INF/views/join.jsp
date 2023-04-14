<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel=stylesheet>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<form action="textMail" method="post">
		<p>이름<input type="text" name="name" required="required"></p>
		<p>메일<input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입(text 메일 발송)">
	</form>
	<hr>	
	<form action="htmlMail" method="post">
		<p>이름<input type="text" name="name" required="required"></p>
		<p>메일<input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입(html 메일 발송)">
	</form>
</body>
</html>