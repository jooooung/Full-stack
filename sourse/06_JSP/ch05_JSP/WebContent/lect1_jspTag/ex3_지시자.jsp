<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- 지시자(<%@ %> : page, include, taglib --%>
<%
	int[] arr = {10, 20, 30};
	out.println(Arrays.toString(arr));
%>
	<hr>
	<%@ include file="../main/footer.jsp" %>	<!-- footer 파일 가져오기 -->
	<hr>
	다시 ex3_지시자.jsp페이지입니다
</body>
</html>