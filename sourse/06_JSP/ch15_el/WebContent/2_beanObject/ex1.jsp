<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  <jsp:useBean id="member" class="com.lec.ex.Member" scope="page"/>
  <jsp:setProperty property="*" name="member"/>
  <h1>bean태그를 이용한 정보 출력</h1>
  <h3>ID : <jsp:getProperty property="id" name="member"/></h3>
  <h3>PW : <jsp:getProperty property="pw" name="member"/></h3>
  <h3>name : <jsp:getProperty property="name" name="member"/></h3>
  <h1>표현식을 이용한 정보 출력</h1>
  <h3>ID : <%=member.getId() %></h3>
  <h3>PW : <%=member.getPw() %></h3>
  <h3>name : <%=member.getName() %></h3>
  <h1>EL 표기법을 이용한 정보 출력</h1>		<!-- EL표기법 사용시 getter 필수 -->
  <h3>ID : ${member.id }</h3>
  <h3>PW : ${member.pw }</h3>
  <h3>name : ${member.name }</h3>
</body>
</html>