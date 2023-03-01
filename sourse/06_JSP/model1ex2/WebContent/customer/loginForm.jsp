<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath(); 
	if(session.getAttribute("customer") != null){
		response.sendRedirect("main.jsp");
	}
	String msg = request.getParameter("msg");
	if(msg != null){
%>
	<script>
		alert('<%=msg%>');
	</script>
<%}%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
   <jsp:include page="../main/header.jsp"/>
   <div id="loginForm_wrap">
   	<div id="login_title">로그인</div>
   <form action="loginPro.jsp" method="post">
   	<input type="hidden" name="method" value="<%=request.getParameter("method")%>">
   	<table>
   		<tr><td></td></tr>
   		<tr>
   			<td><label for="cid">아이디</label></td>
   			<td><input type="text" name="cid" required="required" autofocus="autofocus"
   			
   			
   			
   			>
   		</tr>
   	</table>
   </form>
   </div>
   <jsp:include page="../main/footer.jsp"/>
</body>
</html>