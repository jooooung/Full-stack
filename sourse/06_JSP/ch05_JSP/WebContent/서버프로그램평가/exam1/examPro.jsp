<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body{
			text-align: center;
		}
		h2:first-child{
			color: red;
		}
		button{
			padding: 5px 10px;
			background-color: lightblue;
		}
	</style>
</head>
<body>
	<%
		int su = Integer.parseInt(request.getParameter("su"));
		int answer = (int)(Math.random()*3)+1;
		if(answer == su ){
			out.print("<h2>정답입니다</h2><br><h2>동전이 있던 곳은 " + answer + "</h2>");
		}else{
			String msg = "<h2>Wrong! Try Again!<br>(" + su + "은(는) 아니고 정답은 " + answer + "</h2>";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("exam.jsp?msg="+msg);
		}
	%>
		<button onclick="location.href='exam.jsp'">다시도전</button>
</body>
</html>