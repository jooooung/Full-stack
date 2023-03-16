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
			location.href="${conPath}/loginView.do?next=boardReplyView.do?fid=${param.fid}&pageNum=${param.pageNum}";
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<form action="${conPath }/boardReply.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="fgroup" value="${originBoard.fgroup }">
			<input type="hidden" name="fstep" value="${originBoard.fstep }">
			<input type="hidden" name="findent" value="${originBoard.findent }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<caption>답글쓰기</caption>
				<tr>
					<th>작성자</th>
					<td>
						${member.mname }(${member.mid })
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="ftitle" required="required" class="ftitle" value="${originBoard.ftitle }[답]:">
					</td>
				</tr>
				<tr>
					<th>본문</th>
					<td>
						<textarea rows="5" cols="20" name="fcontent" class="fcontent">${originBoard.fcontent }</textarea>
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
						<input type="submit" value="답글쓰기" class="btn">
						<input type="reset" value="취소" class="btn">
						<input type="button" value="목록" class="btn" onclick="location.href='${conPath }/boardList.do?pageNum=${param.pageNum }'">
					</td>
				</tr>	
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>