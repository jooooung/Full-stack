<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>동전이 있는 곳을 맞춰봐</title>
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
<%!String suParam; int su; %>
	<%
		suParam = request.getParameter("su");
		if(suParam!=null){
			su = Integer.parseInt(suParam);
			int computerSu = (int)(Math.random()*3)+1;
			/* Random random = new Random();
			computerSu = random.nextInt(3)+1; */
			if(su!=computerSu){
				String msg = "<h2>Wrong! Try Again!</h2>"+
										"<h2>("+su+"은(는) 아니고 정답은 "+computerSu+")</h2>";
				msg = URLEncoder.encode(msg,"utf-8");
				response.sendRedirect("exam.jsp?msg="+msg);
			}	
		}else{
			response.sendRedirect("exam.jsp");
		}
	%>
	<div id="wrap">
		<h2>정답입니다</h2>
		<h2>동전이 있던 곳은 <%=su %></h2>
		<button onclick="location.href='exam.jsp'">다시 도전</button>
	</div>
</body>
</html>