<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
<%	// 스크립트릿 안에 자바 소스 
	int j=0;	// 초기화하지 않으면 쓰레기 데이터
	StringBuffer strBuf1 = new StringBuffer("Bad");
	i++; j++;
	strBuf.append("<span> 💜  </span>");
	strBuf1.append("<span> 🤍  </span>");
	out.print("strBuf = " + strBuf + "<br>");		// 브라우저를 꺼도 전역변수는 남아 있다
	out.print("전역변수 i = " + i + "<br>");
	out.print("strBuf1 = " + strBuf1 + "<br>");		
	out.print("지역변수 j = " + j + "<br>");
	out.print("sum(3,4) = " + sum(3,4));
%>
<%!	// 선언부(전역변수, 메소드)	
	int i;	// 선언부에서는 초기화하지 않아도 수는 0, 객체는 null로 자동 초기화
	StringBuffer strBuf = new StringBuffer("Good");
	private int sum(int a, int b){
		return a + b;
	}
%>
</body>
</html>

