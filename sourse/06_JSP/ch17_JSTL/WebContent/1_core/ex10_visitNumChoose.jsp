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
  <c:set var="visitNum" value="${param.visitNum }"/>
  <c:choose> 
  	<c:when test="${visitNum eq 1}">
  		첫 방문 감사
  	</c:when>
  	<c:when test="${visitNum >1 && visitNum <=5}">
  		자주 방문해주세요
  	</c:when>
  	<c:when test="${visitNum > 5}">
  		감사합니다
  	</c:when>
  	<c:otherwise>
			제대로 된 방문 횟수를 받지 못했습니다.
		</c:otherwise>
  </c:choose>
</body>
</html>