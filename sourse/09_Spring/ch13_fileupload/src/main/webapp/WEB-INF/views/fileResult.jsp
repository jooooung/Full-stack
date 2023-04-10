<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>파일 전송 결과 : ${fileUpResult }</h2>
		file1 : upload/${fileNames[0] }<br>
		<c:if test="${not empty fileNames[0] }">
			<img src="${conPath }/upload/${fileNames[0]}"><br>
		</c:if>
		<c:if test="${empty fileNames[0] }">
			file1 첨부 안함<br>
		</c:if>
		file2 : upload/${fileNames[1] }<br>
		<c:if test="${not empty fileNames[1] }">
			<img src="${conPath }/upload/${fileNames[1]}"><br>
		</c:if>
		<c:if test="${empty fileNames[0] }">
			file2 첨부 안함<br>
		</c:if>
		
		file3 : upload/${fileNames[2] }<br>
		<c:if test="${not empty fileNames[2] }">
			<img src="${conPath }/upload/${fileNames[2]}"><br>
		</c:if>
		<c:if test="${empty fileNames[0] }">
			file3 첨부 안함<br>
		</c:if>
	</div>
</body>
</html>