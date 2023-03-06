<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  <%
  	String[] names = {"홍길동", "김길동", "신길동"};
  	/* for(String name : names){
  		out.println("<p>" + name + "</p>");
  	}
  	for(int i=0 ; i<names.length ; i++){
  		out.println("<p>" + i + "번째 " + names[i] + "</p>");
  	} */
  %>
  <c:set var="names" value="<%=names %>"/> <!-- 변수선언 -->
  <c:forEach var="name" items="${names }" varStatus="status">	<!-- names 변수 모두 출력 -->
  	${status.index}${name }<br/> 
  	<%-- <p>${name }</p> --%>
  </c:forEach>
  <c:forEach var="name" items="${names }" begin="1" end="2">	<!-- names 변수 중 1~2번째까지 출력 -->
  	<p>${name }</p>
  </c:forEach>
  <hr>
  <c:set var="idx" value="0"/>	<!-- idx 변수 선언 -->
  <c:forEach var="name" items="${names }">
  	<p>${idx }번째 ${name }</p>
  	<c:set var="idx" value="${idx+1 }"/>	<!-- idx 변수 재선언 -->
  </c:forEach>
  <p>최종 idx는 ${idx }</p> 
</body>
</html>