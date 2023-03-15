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
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<c:if test="${empty member }">
			<script>
				location.href='${conPath}/loginView.do';
			</script>
		</c:if>
	  <form action="modify.do" method="post" enctype="multipart/form-data">
	  	<input type="hidden" name="dbMpw" value="${member.mpw }">	<!-- 비밀번호 미 변경시 현 비밀번호 넘기기 -->
	  	<input type="hidden" name="dbMphoto" value="${member.mphoto }"> <!-- 프로필 미 변경시 현 프로필넘기기 -->
	  	<table>
	  		<caption>정보수정</caption>
	  		<tr>
	  			<th>아이디</th>
	  			<td>
	  				<input type="text" name="mid" value="${member.mid }" readonly="readonly" size="10">
	  			</td>
	  			<td rowspan="4">
	  				<img alt="${member.mname }사진" src="${conPath }/mPhotoUp/${member.mphoto}">
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>현비밀번호</th>
	  			<td>
	  				<input type="password" name="oldMpw" required="required" size="10">
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>새비밀번호</th>
	  			<td>
	  				<input type="password" name="mpw" size="10">
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>이름</th>
	  			<td>
	  				<input type="text" name="mname" value="${member.mname }" required="required" size="10">
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>메일</th>
	  			<td colspan="2">
	  				<input type="text" name="memail" value="${member.memail }">
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>사진</th>
	  			<td colspan="2">
	  				<input type="file" name="mphoto">
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>생년월일</th>
	  			<td colspan="2">
	  				<input type="date" name="mbirth" value="${member.mbirth }">
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>주소</th>
	  			<td colspan="2">
	  				<input type="text" name="maddress" value="${member.maddress }">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="3">
	  				<input type="submit" value="정보수정" class="btn"> 
	  				<input type="reset" value="초기화" class="btn"> 
	  				<input type="reset" value="이전" class="btn" onclick="history.back()"> 
	  				<input type="button" value="회원탈퇴" class="btn" onclick="location.href='${conPath}/withdrawal.do'"> 
	  			</td>
	  		</tr>
	  	</table>
	  </form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>