<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cs = request.getCookies();
		if(cs != null){
			for(Cookie c : cs){
				String cookieName = c.getName();
				if(cookieName.equals("id")){
					// 이름이 id인 쿠키 삭제  = 0초 짜리 이름이 id인 쿠키를 덮어 씌운다
					// 이름=id인 쿠키의 유효시간을 0초로 수정
					c.setMaxAge(0);
					response.addCookie(c);
					out.println("<h2>성공적으로 로그아웃 되었습니다</h2>");
				}else if(cookieName.equals("name")){
					// 이름=name인 쿠키의 유효시간을 0초로 수정
					c.setMaxAge(0);
					response.addCookie(c);
				}// for-if
			}// for
		}// if
	%>
	<p>
		<button onclick="location.href='login.html'">로그인</button>
		<button onclick="location.href='cookieList.jsp'">쿠키 확인</button>
		<button onclick="location.href='welcome.jsp'">메인페이지</button>
	</p>
</body>
</html>