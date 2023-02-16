<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
		<%-- 이페이지는 ex2.jsp에서 예외가 발생하면 오는 페이지 ( 0으로 나눌 때 예외 - 500 에러 --%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<%-- 
	200: 정상상태
	400: 형식이 잘못된 것
	404: 해당 문서를 못 찾을때
	407: 인증을 받지 못한 경우
	500: 문법오류나 예외 발생 상태
--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		console.log('예외타입 : ' + '<%=exception.getClass().getName()%>');
		console.log('예외 메세지 : ' + '<%=exception.getMessage()%>');
	</script>
</head>
<body>
	<h1>공사중입니다</h1>
	<%
		System.out.println("예외 메세지 : " + exception.getMessage());
		System.out.println("예외 타입 : " + exception.getClass().getName());
	%>
</body>
</html>