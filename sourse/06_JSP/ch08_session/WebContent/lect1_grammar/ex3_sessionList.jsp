<%@page import="java.util.Enumeration"%>
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
		// 세션에 추가한 모든 데이터 리스트
		out.println("<h1>모든 세션 속성들</h1>");
		Enumeration<String> sAttrNames = session.getAttributeNames();
		int cnt = 0;
		while(sAttrNames.hasMoreElements()){
			String sname = sAttrNames.nextElement();
			String svalue = session.getAttribute(sname).toString();
			out.println("<h2>" + sname + "(세션속성 이름) : " + svalue + "(세션값</h2>)");
			cnt++;
		}//while
		if(cnt==0){
			out.println("<h2>세션 속성이 없습니다</h2>");
		}
	%>
	<hr>
	<a href="ex1_sessionAddAttribute.jsp">세션 데이터 추가</a><br>
	<a href="ex2_sessionGet.jsp">특정 세션 GET</a><br>
	<a href="ex3_sessionList.jsp">모든 세션 데이터 리스트</a><br>
	<a href="ex4_sessionRemove.jsp">세션 삭제(특정 세션 or 전체)</a><br>
</body>
</html>