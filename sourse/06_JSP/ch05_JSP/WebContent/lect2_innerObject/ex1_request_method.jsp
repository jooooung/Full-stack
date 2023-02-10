<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>	<%-- 127.0.0.1 : IPv4, 0.0.0.0.0.1 : IPv6 --%>
	<h2>요청한 곳의 IP주소 : ✨<%=request.getRemoteAddr() %></h2>
</body>
</html>