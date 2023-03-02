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
	<h1>표현식 태그 이용</h1>
 	<p>산술연산자 : 10+1   = <%=10+1 %></p>
 	<p>산술연산자 : 10/0.0 = <%=10/0.0 %></p>		<!-- java에서는 0으로 나누면 에러 -->
 	<p>관계연산자 : 1 > 2  = <%=1 > 2 %></p>
 	<p>관계연산자 : 1 == 2 = <%=1==2 %></p>
 	<p>관계연산자 : 1 != 2 = <%=1!=2 %></p>
 	<p>조건연산자 : <%=(1>2)? "1이 2보다 큽니다" : "1이 2보다 크지 않습니다"%></p>
 	<p>논리연산자 : (1>2) || (1&lt;2) = <%=(1>2) || (1<2) %></p>
 	<p>로그인 여부 : <%=session.getAttribute("customer")==null? "로그인 안함" : "로그인 함" %></p>
 	<p>로그인 여부 : <%=session.getAttribute("customer")!=null? "로그인 함" : "로그인 안함" %></p>
 	<p>pageNum 여부 : <%=request.getParameter("pageNum")==null? "pageNum안 옴" : "pageNum 옴"%></p>
 	<p>su파라미터 값 : <%=request.getParameter("su")%></p>		<!-- 표현식은 null -->
 	<hr>
  <h1>EL 표기법 이용(표현식 안에 쓸 수 있는 연산자는 다 사용 가능)</h1>
 	<p>산술연산자 : 10 + 1 = ${10+1}</p>
 	<p>산술연산자 : 10 / 0 = ${10/0}</p>
  <p>관계연산자 : 1 > 2  = ${1 gt 2}</p>
  <p>관계연산자 : 1 > 2  = ${1 > 2}</p>
  <p>관계연산자 : 1 == 2 = ${1 eq 2}</p>
  <p>관계연산자 : 1 != 2 = ${1 != 2}</p>
  <p>조건연산자 : ${(1>2)? "1이 2보다 큽니다" : "1이 2보다 크지 않습니다"}</p>
  <p>논리연산자 : (1>2) || (1&lt;2) = ${(1>2) || (1<2)}</p>	  <!-- &lt; = <  사용이유 <를 태그로 인식오류가 생길 수도 있어서-->
  <p>로그인 여부(eq) : ${customer eq null? "로그인 안함" : "로그인 함"}</p> <!-- (sessionScope).customer -->
  <p>로그인 여부(empty) : ${empty customer? "로그인 안함" : "로그인 함"}</p> 
  <p>로그인 여부(not empty) : ${not empty customer? "로그인 함" : "로그인 안함"}</p>
  <p>pageNum 여부 : ${empty param.pageNum? "pageNum안 옴" : "pageNum 옴"}</p>
  <P>su파라미터 값 : ${param.su }</P>	<!-- EL에서는 "" -->
  <P>su파라미터 대문자 변경 : ${param.su.toUpperCase() }</P>		<!-- 오류가 나지 않는다 -->
</body>
</html>