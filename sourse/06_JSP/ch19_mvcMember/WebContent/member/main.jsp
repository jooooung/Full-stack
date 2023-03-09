<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:if test="${not empty member }">
		<table>
		  <tr>
		  	<td>${member.mname }(${member.mid })님 어세오세요</td>
		  </tr>
		  <tr>
		 		<td><button onclick="location.href='${conPath}/logout.do'">로그아웃</button></td>
		 	</tr>
	 	</table>
	</c:if>
	<c:if test="${empty member }">
		<table>
		  <tr>
		  	<td>로그인 상태가 아닙니다</td>
		  </tr>
		  <tr>
		 		<td>
					<button onclick="location.href='${conPath}/loginView.do'" >로그인</button>
	  			<button onclick="location.href='${conPath}/joinView.do'">회원가입</button>
				</td>
		 	</tr>
	 	</table>
	</c:if>
</body>
</html>
