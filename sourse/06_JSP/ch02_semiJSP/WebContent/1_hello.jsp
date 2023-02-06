<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>이 파일은 1_hello.jsp입니다</h1>
	<%
		int total = 0;
		for(int cnt=1 ; cnt<=100 ; cnt++){
			total += cnt;
		}
	%>
	<h2>1부터 100까지 누적합 : <%=total %></h2>
</body>
</html>