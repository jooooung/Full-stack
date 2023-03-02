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
	<form action="ex2_scope.jsp">
		<p>ID <input type="text" name="id"> </p>
		<p>PW <input type="password" name="pw"> </p>
		<p>name <input type="text" name="name"> </p>
		<p><input type="submit"> </p>
  </form>
	  <%	// 자바에서 할 로직
	  	pageContext.setAttribute("pageName", "pageValue");		/* 페이지 닫기 전까지 유효 */
	  	request.setAttribute("requestName", "requestValue");	/* 새 request 전까지 유효 */
	  	session.setAttribute("sessionName", "sessionValue");	/* 브라우저 닫기 전까지 유효 */
	  	application.setAttribute("applicationName", "applicationValue");	/* 브라우저 닫아도(서버 끌때까지) 유효 */
	  	// 자바에서 forward할 객체 생성(request객체 미생성)
	  	RequestDispatcher dispatcher = request.getRequestDispatcher("ex2_scope.jsp?id=aaa&pw=aaa&name=aaa");
	  	// dispatcher 이용하여 forward
	  	dispatcher.forward(request, response);
	  %>
	  <%-- <jsp:forward page="ex2_scope.jsp">
	  	<jsp:param value="aaa" name="id"/>
	  	<jsp:param value="aaa" name="pw"/>
	  	<jsp:param value="aaa" name="name"/>
	  </jsp:forward> --%>
	  <h3>페이지 내 attribute : <%=pageContext.getAttribute("pageName") %></h3>
	  <h3>request 내 attribute : <%=request.getAttribute("requestName") %></h3>
	  <h3>session 내 attribute : <%=session.getAttribute("sessionName") %></h3>
	  <h3>application 내 attribute : <%=application.getAttribute("applicationName") %></h3>
	  <hr>
	  <h3>페이지 내 attribute : ${pageScope.pageName }</h3>
	  <h3>request 내 attribute : ${requestScope.requestName }</h3>
	  <h3>session 내 attribute : ${sessionScope.sessionName }</h3>
	  <h3>application 내 attribute : ${applicationScope.applicationName }</h3>
	  <hr>
	  <!-- Scope 변수 생략 가능  - 알아서 찾는다 -> 1.변수 2.ps 3.rs 4. ss 5. ap-->
	  <!-- 따라서 각각 이름이 달라야한다 -->
	  <h3>페이지 내 attribute : ${pageName }</h3>			
	  <h3>request 내 attribute : ${requestName }</h3>			
	  <h3>session 내 attribute : ${sessionName }</h3>			
	  <h3>application 내 attribute : ${applicationName }</h3>			
</body>
</html>