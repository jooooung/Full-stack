<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%-- <%session.setAttribute("customer", "test"); %> --%>
	<%session.setAttribute("admin", "test"); %>
	<c:if test="${empty customer && empty admin}">
	 <!-- 로그인 전 -->
	 <ul>
	 	<li><a href="#">로그인</a></li>
	 </ul>
	</c:if>
	<c:if test="${not empty customer && empty admin }">
	<!-- 사용자 로그인  : session.setAttribute("customer", customer);-->
		<ul>
	 		<li><a href="#">고객센터</a></li>
	 	</ul>	
	</c:if>
	<!-- 관리자 로그인  : session.setAttribute("admin", admin);-->
	<c:if test="${empty customer && not empty admin }">
		<ul>
	 		<li><a href="#">공지사항</a></li>
	 	</ul>	
	</c:if>
</body>
</html>