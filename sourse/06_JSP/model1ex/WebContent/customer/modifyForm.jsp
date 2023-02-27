<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/modify.css" rel="stylesheet" type="text/css">
	<script>
		// pw pwChk 같은지, email 유효성 검사
	</script>
</head>
<body>
	<%! 
			String cid, cname, ctel, cgender, cemail, caddress;
			Date cbirth;		
	%>
	<%
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer==null){	// 정보가 없다면 로그인 페이지로
			// 정보수정 페이지에서 로그인시 main페이지가 아닌 정보수정 페이지로 가게 하기
			response.sendRedirect("loginForm.jsp?method=modifyForm");	
		}else{
			cid = customer.getCid();
			cname = customer.getCname();
			ctel = customer.getCtel();
			cgender = customer.getCgender();
			cemail = customer.getCemail();
			caddress = customer.getCaddress();
			cbirth = customer.getCbirth();
		}
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="modifyForm_wrap">
		<div id="modify_title">정보수정</div>
			<form action="modifyPro.jsp" method="post">
				<table>
					<tr>
						<th><label for="cid">아이디</label></th>
						<td><input type="text" name="cid" value="<%=cid%>" class="cid" readonly="readonly"></td>	<!-- id -  변경불가 : readonly="readonly" -->
					</tr>
					<tr>
							<th><label for="oldcpw">비밀번호</label></th>
						<td><input type="password" name="oldcpw" required="required" class="coldPw">
					</tr>
					<tr>
						<th><label for="cpw">새비밀번호</label></th>
						<td><input type="password" name="cpw" class="cpw" placeholder="비밀번호 수정을 원하지 않으면 입력하지 마세요">
					</tr>
					<tr>
						<th>새비밀번호확인</th>
						<td><input type="password" name="cpwChk" class="cpwChk">
					</tr>
					<tr>
						<th><label for="cpwChk">이름</label></th>
						<td><input type="text" name="cname" value="<%=cname%>" class="cname" required="required"></td>
					</tr>
					<tr>
						<th><label for="ctel">전화번호</label></th>
						<td><input type="text" name="ctel" value='<%=ctel==null? "" : ctel %>' class="ctel"></td>
					</tr>
					<tr>
						<th><label for="cemail">이메일</label></th>
						<td><input type="email" name="cemail" value='<%=cemail == null? "" : cemail%>' class="cemail">
					</tr>
					<tr>
						<th><label for="cbirth">생년월일</label></th>
						<td><input type="date" name="tempBirth" value='<%=cbirth== null? "" : cbirth.toString()%>' class="cbirth"></td>
					</tr>
					<tr>
						<th><label for="caddress">주소</label></th>
						<td><input type="text" name="caddress" value='<%=caddress == null? "" : caddress%>' class="caddress">
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<%if("m".equals(cgender)){ %>
								<input type="radio" name="cgender" value="m" checked="checked">남자
								<input type="radio" name="cgender" value="f">여자
							<%}else if("f".equals(cgender)){ %>
								<input type="radio" name="cgender" value="m">남자
								<input type="radio" name="cgender" value="f" checked="checked">여자
							<%}else{ %>
								<input type="radio" name="cgender" value="m">남자
								<input type="radio" name="cgender" value="f">여자
							<%} %>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="정보수정" class="modifyBtn_style">
							<input type="reset" value="취소" onclick="history.back()" class="modifyBtn_style">
							<input type="button" value="로그아웃" 
										onclick="location.href='logout.jsp'" class="modifyBtn_style">
						</td>
					</tr>
				</table>
			</form>
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>