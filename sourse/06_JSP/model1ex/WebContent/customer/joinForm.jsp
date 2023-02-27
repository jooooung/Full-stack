<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	if(session.getAttribute("customer")!=null){
		response.sendRedirect(conPath + "main/main.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
	<script>
	const infoConfirm = function () {
		var patternMail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;	// match함수 사용
		if(join_frm.id.value.length < 3){	// 아이디 3글자이상
			alert('아이디를 3글자 이상 입력해주세요');
			join_frm.id.focus();
			return;
		}
		if(! join_frm.pw.value){
			alert('비밀번호를 입력해주세요');
			join_frm.pw.focus();
			return;
		}
		if(join_frm.pw.value != join_frm.pwChk.value){
			alert('비밀번호가 일치하지 않습니다');
			join_frm.pw.value = '';
			join_frm.pwChk.value = '';
			join_frm.pw.focus();
			return;
		}
		if(!join_frm.name.value){
			alert('이름을 입력해주세요');
			join_frm.name.focus();
			return;
		}
		if(join_frm.email.value && !join_frm.email.value.match(patternMail)){
			alert('메일 형식을 확인하세요');
			join_frm.email.focus();
			return;
		}
		join_frm.submit();	// 강제로 submit 이벤트 발생
	};
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">회원가입</div>
		<form action="joinPro.jsp" method="post">
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" class="cid" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpw">비밀번호</label></th>
					<td><input type="password" name="cpw" id="cpw" class="cpw" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpwChk">비밀번호확인</label></th>
					<td><input type="password" name="cpwChk" id="cpwChk" class="cpwChk"></td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td><input type="text" name="cname" id="cname" class="cname" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td><input type="text" name="ctel" id="ctel" class="ctel"></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="email" name="cemail" id="cemail" class="cemail"></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" id="caddress" class="caddress"></td>
				</tr>
				<tr>
					<th><label for="cbirth">생년월일</label></th>
					<td><input type="date" name="tempBirth" id="cbirth" class="cbirth"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="cgender" value="m" checked="checked" id="m"><label for="m">남자</label>
						<input type="radio" name="cgender" value="f" id="f"><label for="f">여자</label>
					</td>
				</tr>
				<tr>
					<td colspan="2"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="로그인" class="joinBtn_style" 
											onclick="location.href='<%=conPath%>/customer/loginForm.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>