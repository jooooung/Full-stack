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
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		out.println("<h2>num1 = " + num1 + "</h2>");
		out.println("<h2>num2 = " + num2 + "</h2>");
		out.println("<h2>num1 + num2 = " + (num1 + num2) + "</h2>");
		try{
		out.println("<h2>num1 / num2 = " + (num1 / num2) + "</h2>");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		out.println("<h2>num1 * num2 = " + (num1 * num2) + "</h2>");
		out.println("<h2>num1 - num2 = " + (num1 - num2) + "</h2>");
	%>	
</body>
</html>