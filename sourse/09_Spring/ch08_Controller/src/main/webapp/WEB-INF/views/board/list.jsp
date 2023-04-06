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
</head>
<body>
	<h3>board의 list.jsp페이지입니다</h3>
	<c:if test="${list.size() eq 0 }">
		<h4>추가된 member가 없습니다</h4>
	</c:if>	
	<c:if test="${list.size() != 0 }">
		<c:forEach var="member" items="${list }">
			<h4>ID : ${member.id }</h4>
			<h4>PW : ${member.pw }</h4>
		</c:forEach>
		<h4>이상 ${list.size() }명</h4>
	</c:if>
	<hr>
	<h4 onclick="history.go(-1)">이전페이지</h4>
</body>
</html>