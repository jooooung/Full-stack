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
	<c:set var="mid" value=""/>
	<c:if test="${not empty member.mid }">
		${mid } = ${member.mid  }
	</c:if>
  <form action="login.do" method="post">
  	<table>
  		<caption>로그인</caption>
  		<tr>
  			<td>ID</td>
  			<td>
  				<input type="text" name="mid" required="required" value="${mid }">
  			</td>
  		</tr>
  		<tr>
  			<td>PW</td>
  			<td> 
  				<input type="password" name="mpw" required="required">
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2">
  				<input type="submit" value="로그인" class="btn">
  				<input type="button" value="회원가입" class="btn"
  							 onclick="location.href='${conPath}/member/join.jsp'">
  			</td>
  		</tr>
  	</table>
  </form>
</body>
</html>
