<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath(); 
	if(session.getAttribute("member")!=null){	// 로그인 상태
		response.sendRedirect("main.jsp");	// 로그인 했다면 메인페이지로
	}
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="loginOk.jsp" method="post">
		<!-- modify 에서 로그인 시 modify 페이지로 보내기 위한 input -->
		<input type="hidden" name="method" value="<%=request.getParameter("method")%>">
		<table>
			<caption>로그인</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" required="required" 
									value='<%
													String id = (String)session.getAttribute("id");
													
													%>'>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='join.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>