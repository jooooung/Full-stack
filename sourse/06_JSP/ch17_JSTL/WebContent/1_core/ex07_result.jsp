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
	<c:set var="n1" value="${param.n1 }"/>
	<c:set var="n2" value="${param.n2 }"/>
	<c:set var="n3" value="${param.n3 }"/>
  <c:if test="${n1+n2 eq n3 }">
  	${n1 } + ${n2 } = ${n3 } 정답입니다
  </c:if>
  <c:if test="${n1+n2 != n3 }" var="result" scope="page">
  	${n1 } + ${n2 } = ${n3 } 틀렸습니다
  </c:if>
	두번째 if문 조건에 대한 결과는 ${result }
</body>
</html>