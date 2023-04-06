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
	<link href="${conPath }/css/style.css" rel=stylesheet>
</head>
<body>
	<div id="wrap">
	<p>현재 총 ${cnt }명</p>
	<table>
		<caption>결과는 다음과 같습니다</caption>
		<tr>
			<th>이  름 : </th>
			<td>${student.name }</td>
		</tr>
		<tr>
			<th>국  어 : </th>
			<td>${student.kor }</td>
		</tr>
		<tr>
			<th>영  어 : </th>
			<td>${student.eng }</td>
		</tr>
		<tr>
			<th>수  학 : </th>
			<td>${student.mat }</td>
		</tr>
		<tr>
			<th>총  점 : </th>
			<td>
				${student.kor + student.mat + student.eng }
			</td>
		</tr>
		<tr>
			<th>평  균 : </th>
			<td>
				<fmt:formatNumber value="${(student.kor+student.mat+student.eng)/3 }" 
								  pattern="###.##"/> 
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="history.back()" class="btn">뒤로가기</button>
				<button onclick="location.href='${conPath}/'" class="btn">다시입력</button>
			</th>
		</tr>
	</table>
	</div>
</body>
</html>