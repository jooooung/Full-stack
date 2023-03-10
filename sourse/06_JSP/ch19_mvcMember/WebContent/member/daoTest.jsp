<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dao.MemberDao"%>
<%@page import="com.lec.ex.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  <%
		MemberDao dao = new MemberDao();
		out.println("<h3>1.회원id중복체크</h3>");
		if(MemberDao.FAIL == dao.midConfirm("bbb")){
			out.println("bbb는 중복된 ID");
		}else if(MemberDao.SUCCESS== dao.midConfirm("bbb")){
			out.println("bbb는 사용가능한 ID");
		}
		out.println("<h3>2.회원가입</h3>");
		int result = dao.join(new MemberDto("v","v","홍길",null,"NOIMG.JPG",null, null,null));
		if(result == MemberDao.SUCCESS){
			out.println("회원가입 성공");
		}else if(result == MemberDao.FAIL){
			out.println("회원가입 실패");
		}
		out.println("<h3>3.로그인</h3>");
		result = dao.loginChk("a", "1");
		if(result == MemberDao.SUCCESS){
			out.println("<p>a-1 로그인성공</p>");
		}
		result = dao.loginChk("a", "9");
		if(result == MemberDao.FAIL){
			out.println("<p>a - 9 로그인실패</p>");
		}
		out.println("<h3>4.mid로 dto가져오기</h3>");
		MemberDto member = dao.getMember("a");
		out.println("<p>"+member+"</p>");
		
		out.println("<h3>5.회원정보수정(a)</h3>");
		String mid = "b";
		out.println("<p>수정 전 : "+member+"</p>");
		member.setMname("박");
		member.setMemail("w@w.com");
		dao.modifyMember(member); // 회원 정보 수정
		out.println("<p>수정 후 : "+dao.getMember(mid)+"</p>");
		
		out.println("<h3>6.회원리스트</h3>");
		ArrayList<MemberDto> members = dao.memberList(1, 3);
		for(MemberDto m : members){
			out.println(m + "<br>");
		}
		out.println("<h3>7.전체회원수</h3>");
		out.println(dao.getMemberTotCnt());
		
		out.println("<h3>8.a회원탈퇴</h3>");
		dao.withdrawalMember(mid);
		out.println(result == MemberDao.SUCCESS? "탈퇴완료":"탈퇴실패");
		
	%>
</body>
</html>