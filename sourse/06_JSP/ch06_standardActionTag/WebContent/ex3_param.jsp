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
	<!-- ex3_param.jsp?n=1 파라미터 넘기기 -->
	<h1>ex3_param.jsp입니다</h1>	
	<jsp:forward page="ex4.jsp">
		<jsp:param value="aaa" name="id"/>
		<jsp:param value="111" name="pw"/>
	</jsp:forward>
</body>
</html>