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
  <form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
  	<table>
  		<caption>회원가입</caption>
  		<tr>
  			<td>아이디</td>
  			<td> <input type="text" name="mid" required="required" autofocus="autofocus"></td>
  		</tr>
  		<tr>
  			<td>비밀번호</td>
  			<td> <input type="password" name="mpw" required="required"></td>
  		</tr>
  		<tr>
  			<td>이름</td>
  			<td> <input type="text" name="mname" required="required"></td>
  		</tr>
  		<tr>
  			<td>메일</td>
  			<td> <input type="email" name="memail"></td>
  		</tr>
  		<tr>
  			<td>사진</td>
  			<td>
  				<c:if test=""></c:if>
  				<input type="file" name="mphoto">
  			</td>
  		</tr>
  		<tr>
  			<td>생년월일</td>
  			<td> <input type="date" name="mbirth"></td>
  		</tr>
  		<tr>
  			<td>주소</td>
  			<td> <input type="text" name="maddress"></td>
  		</tr>
  		<tr>
  			<td colspan="2">
  				<input type="submit" value="회원가입" class="btn">
  				<input type="button" value="로그인" class="btn"
  							 onclick="location.href='${conPath}/loginView.do'">
  			</td>
  		</tr>
  	</table>
  </form>
</body>
</html>