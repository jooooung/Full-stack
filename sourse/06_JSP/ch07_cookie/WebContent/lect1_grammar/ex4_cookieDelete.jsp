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
	<h1>특정 쿠키(cookieName) 삭제하기</h1>	
	<%	// 같은 이름의 쿠키를 유효시간을 0초로 생성 후 response 탑재
			Cookie[] cookies = request.getCookies();	// 배열로 쿠키 가져오기
			if(cookies != null){	// 쿠키가 있다면
				for(Cookie c : cookies){
					String name = c.getName();	// name 얻기
					if(name.equals("cookieName")){	// 삭제할 쿠기의 name이 있다면
						Cookie cookie = new Cookie("cookieName", "xxx");	// 같은 이름의 쿠키 새로 만들기
						cookie.setMaxAge(0);	// 유효시간 0초로 설정
						response.addCookie(cookie);	// response 객체에 쿠키 탑재
						out.println("<h3>쿠키 삭제 성공</h3>");
						break;	
					}// if
				}// for
			}// if 
	%>
	<hr>
		<a href="ex1_cookieConstruct.jsp">쿠키 생성</a><br>
		<a href="ex2_cookieList.jsp">쿠키 리스트</a><br>
		<a href="ex3_thatCookie.jsp">특정 쿠키(쿠키 이름이 cookieName) 찾기</a><br>
		<a href="ex4_cookieDelete.jsp">특정 쿠키 지우기</a><br>
</body>
</html>