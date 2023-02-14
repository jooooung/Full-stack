<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		header{
			width: 1000px;
			margin: 0 auto;	
		}
		header ul{overflow: hidden;}
		header ul li{
			list-style: none;
			float: right;
			padding: 10px 30px;
		}
		header ul li a{
			text-decoration: none;
			font-weight: bold;
			font-size: 1.2em;
			color: #807060;
		}
	</style>
</head>
<body>
	<header>
		<div id="nav">
		<%
			String name = (String)session.getAttribute("name");		
		%>
		<% if(name == null){%>
				<ul>
					<li><a href="<%=conPath%>/member/join.jsp">회원가입</a></li>
					<li><a href="<%=conPath%>/member/login.jsp">로그인</a></li>
					<li><a href="<%=conPath%>/member/main.jsp">홈</a></li>
				</ul>
		<%}else{%>
					<ul>
						<li><a href="<%=conPath%>/member/logout.jsp">로그아웃</a></li>
						<li><a href="#">정보수정</a></li>
						<li><a href="<%=conPath%>/member/main.jsp"><%=name %>님</a></li>
					</ul>
		<%} %>	
		</div>
	</header>
</body>
</html>
