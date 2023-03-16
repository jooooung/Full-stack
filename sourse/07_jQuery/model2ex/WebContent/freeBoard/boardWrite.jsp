<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(function(){
		
		});
		function checkSize(input) {
		    if (input.files && input.files[0].size > (3 * 1024 * 1024)) {
		        alert("용량이 3mb를 넘습니다.");
		        input.value = null;
		    }
		} //  업로드 용량 제한
	</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty member }">
		<script>
			location.href="${conPath}/loginView.do?next=boardWrite.do";
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<form action="${conPath }/boardWrite.do" method="post" enctype="multipart/form-data">
		<table>
			<caption>글쓰기</caption>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="ftitle" required="required" class="ftitle">
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td>
					<textarea rows="5" cols="20" name="fcontent" class="fcontent"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="ffilename" onchange="checkSize(this)">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn" onclick="${conPath}/boardList.do">
				</td>
			</tr>	
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>