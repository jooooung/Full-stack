<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.lec.member.MemberDto"%>
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
	<h1>테스트 페이지</h1>	
	<%
		MemberDaoConn dao = new MemberDaoConn();
		String id = ("aaa");
		int result = dao.confirmId(id);
		if(result == MemberDaoConn.MEMBER_EXISTENT){
			out.println("<h3>.1 confirmId결과 : " + id + "는 있는 ID. 회원가입 불가");
		}else{
			out.println("<h3>.1 confirmId결과 : " + id + "는 없는 ID. 회원가입 가능");
			MemberDto dto = new MemberDto(id, "111", "킴", null, null, null, null, null,
					null, null, null);
			result = dao.joinMember(dto);
			if(result == MemberDaoConn.SUCCESS){
				out.println("<h3>2. join 결과 : 회원가입 성공");
			}else{
				out.println("<h3>2. join 결과 : 회원가입 실패" + dto);
			}
		}
		
		out.println("<h3>3. 로그인결과</h3>");
		result = dao.loginCheck("aaa", "111");
		if(result == MemberDaoConn.LOGIN_SUCCESS){
				out.println("<h3>3. login 결과 : 로그인 성공");
		}else if(result == MemberDaoConn.LOGIN_FAIL_ID){
				out.println("<h3>3. login 결과 : id 틀림 로그인 실패");
		}else if(result == MemberDaoConn.LOGIN_FAIL_PW){
				out.println("<h3>3. login 결과 : pw 틀림 로그인 실패");
		}
		
		out.println("<h3>3. 로그인결과(id틀리게)</h3>");
		result = dao.loginCheck("aa", "111");
		if(result == MemberDaoConn.LOGIN_SUCCESS){
				out.println("<h3>3. login 결과 : 로그인 성공");
		}else if(result == MemberDaoConn.LOGIN_FAIL_ID){
				out.println("<h3>3. login 결과 : id 틀림 로그인 실패");
		}else if(result == MemberDaoConn.LOGIN_FAIL_PW){
				out.println("<h3>3. login 결과 : pw 틀림 로그인 실패");
		}
		
		out.println("<h3>3. 로그인결과(pw틀리게)</h3>");
		result = dao.loginCheck("aaa", "11");
		if(result == MemberDaoConn.LOGIN_SUCCESS){
				out.println("<h3>3. login 결과 : 로그인 성공");
		}else if(result == MemberDaoConn.LOGIN_FAIL_ID){
				out.println("<h3>3. login 결과 : id 틀림 로그인 실패");
		}else if(result == MemberDaoConn.LOGIN_FAIL_PW){
				out.println("<h3>3. login 결과 : pw 틀림 로그인 실패");
		}
		
		out.println("<h3>4. id로 dto가져오기</h3>");
		MemberDto dto = dao.getMember("aaa");
		out.println("aaa 아이디의 member : " + dto + "<br>");
		dto = dao.getMember("s");
		out.println("s 아이디의 member : " + dto + "<br>");
		
		out.println("<h3>5. 정보수정</h3>");
		dto = new MemberDto("aaa", "111", "홍길동", null, null, null, null, "q@qqq.com",
				null, "인천", null);
		result = dao.modifyMember(dto);
		if(result == MemberDaoConn.SUCCESS){
			out.println("수정완료");
			out.println("db의 수정된 데이터 : " + dao.getMember(dto.getId()) + "<br>");
		}else{
			out.println(dto.getId() + " 가 없어서 수정 불가<br>");
		}
	%>
</body>
</html>