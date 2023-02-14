<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap{
			height: 600px;
			font-size: 32px;
			text-align: center;
			width: 800px;
			margin: 0 auto;
		}
	</style>
</head>
<body>
	<jsp:include page="../member/header.jsp"/>
	<div id="mainForm_wrap">
		<br><br>
		<h3>쿠키 리스트</h3>
		<% 
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie c : cookies){
					String cname = c.getName();
					String cvalue = c.getValue();
					out.println("<p>" + cname + "(쿠키이름) : " + cvalue + "(쿠키값)</p>");
				}
			}else{
				out.println("<P>쿠키가 없습니다</p>");
			}
		
		%>
	</div>		
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>