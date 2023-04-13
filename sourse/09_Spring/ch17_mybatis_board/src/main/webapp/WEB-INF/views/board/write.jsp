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
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script>
		$().ready(function(){
			
		});
		function bnameLimit(bname, maxlength){
			if(bname.value.length > maxlength)  {
				bname.value 
			      = bname.value.substr(0, maxlength);
			  }
		} // 작성자 입력 길이 제한
		function btitleLimit(btitle, maxlength){
			if(btitle.value.length > maxlength)  {
				btitle.value 
			      = btitle.value.substr(0, maxlength);
			  }
		} // 제목 입력 길이 제한
		function bcontentLimit(bcontent, maxlength){
			if(bcontent.value.length > maxlength)  {
				bcontent.value 
			      = bcontent.value.substr(0, maxlength);
			  }
		} // 본문 입력 길이 제한
	</script>
</head>
<body>
	<form action="${conPath }/board/write.do" method="post">
		<input type="hidden" name="bip" value="${bip }">
		<table>
			<caption>글쓰기</caption>
			<tr>
				<th>작성자 ${bip }</th>
				<td>
					<input type="text" name="bname" required="required" autofocus="autofocus" oninput="bnameLimit(this, 16)">
				</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>
					<input type="text" name="btitle" required="required" oninput="btitleLimit(this, 33)">
				</td>
			</tr>
				<th>본문</th>
				<td>
					<textarea rows="5" cols="20" name="bcontent" oninput="bcontentLimit(this, 333)"></textarea>
				</td>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn" onclick="history.back()">
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>