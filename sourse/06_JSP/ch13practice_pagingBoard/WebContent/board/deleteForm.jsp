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
  <%
  String num = request.getParameter("num");
	String pageNum = request.getParameter("pageNum");
  %>
  <table>
  	<caption><%=num %>번 글 삭제</caption>
  	<tr>
  		<td>
  			<fieldset>
  				<legend>글비밀번호</legend>
  				<form action="deletePro.jsp" method="post">
  					<input type="hidden" name="num" value="<%=num%>">
  					<input type="hidden" name="pageNum" value="<%=pageNum%>">
  					<input type="password" name="pw" required="required" autofocus="autofocus" class="btn">
  					<input type="submit" value="삭제" class="btn">
  					<input type="button" value="취소" class="btn" onclick="history.back()">
  				</form>
  			</fieldset>
  		</td>
  	</tr>
  </table>
</body>
</html>