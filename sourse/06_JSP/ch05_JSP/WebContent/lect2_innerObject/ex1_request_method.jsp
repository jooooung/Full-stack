<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
</head>
<body>	<%-- 127.0.0.1 : IPv4, 0.0.0.0.0.1 : IPv6 --%>
	<h2>요청한 곳의 IP주소 :  ✨<%=request.getRemoteAddr() %></h2>	<!-- IP 주소 표시 -->
	<h2>ContextPath : ✨ <%=request.getContextPath() %></h2>	<!-- 프로젝트 경로를 표시 -->
	<h2>요청방식 : <%=request.getMethod() %> </h2>
	<h2>세선객체 :  ✨ <%=request.getSession() %> </h2>	
	<h2>요청 URL : <%=request.getRequestURL() %> </h2>	
	<h2>요청 URI :  ✨ <%=request.getRequestURI() %> </h2>		<%-- 포트번호를 제외한 주소 --%>
	<h2>해당 프로토콜 : <%=request.getProtocol() %> </h2>	
	<h2>서버이름 : <%=request.getServerName() %> </h2>	
	<h2>포트번호 : <%=request.getServerPort() %> </h2>	
</body>
</html>