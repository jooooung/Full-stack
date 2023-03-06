<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  <h2>core 라이브러리 태그 : if, for, choose, set...</h2>
  <c:forEach var="i" begin="1" end="3" step="1">
  	<p>${i }번째 안녕하세요</p>
  </c:forEach>
  <hr>
  <c:forEach begin="1" end="3" step="1">
  	<p>안녕하세요</p>
  </c:forEach>
  <hr>
  <h2>fmt 라이브러리 태그 : 날짜, 숫자format, 다국어지원</h2>
  <fmt:formatNumber value="3333.149" pattern="#,###.##"/>
  <hr>
  <h2>그 외 라이브러리 태그(functions) : fn 라이브러리는 el 표기법과 함께 사용</h2>
  id 파라미터를 대문자로 : ${fn:toUpperCase(param.id) }<!-- functions 라이브러리 사용 -->
  id 파라미터를 대문자로 : ${param.id.toUpperCase }<!-- java함수 사용 -->
</body>
</html>