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
  <h1><a href="empList">EmpList</a></h1><!-- servlet 파일로 보내기 -->
  <!-- EmpList.java(servlet, 프로세스), empList.jsp(뷰) -->
  <h1><a href="${conPath }/empSch">empSch(이름,직업으로 검색 list 출력)</a></h1>
  <!-- EmpSch.java(servlet, 프로세스), empSch.jsp(뷰) -->
</body>
</html>