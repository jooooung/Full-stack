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
  <c:if test="${not empty modifyResult }">
	<script>
		alert('${modifyResult}');
		history.back();
	</script>
  </c:if>	
  <!-- model의 board, param.bid, param.pageNum -->
  <form action="${conPath }/board/modify.do" method="post">
  	<input type="hidden" name="pageNum" value="${param.pageNum }">  <!-- hidden 타입으로 pageNum 넘기기 -->
  	<input type="hidden" name="bid" value="${board.bid }">	<!-- hidden 타입으로 bid 넘기기 -->
  	<input type="hidden" name="bip" value="${bip }"> 
  	<table>
  		<caption>${board.bid }번 글 수정</caption>
	 	<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="bname" value="${board.bname }" required="required" oninput="bnameLimit(this, 16)">
			</td>  	
  		</tr>
  		<tr>
  			<th>제목</th>
  			<td>
  				<input type="text" name="btitle" value="${board.btitle }" required="required" oninput="btitleLimit(this, 33)">
  			</td>
  		</tr>
  		<tr>
  			<th>본문</th>
  			<td>
  				<textarea rows="5" name="bcontent" oninput="bcontent(this, 333)">${board.bcontent }</textarea>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2">
  				<input type="submit" value="수정" class="btn"> 
  				<input type="reset" value="취소" class="btn" onclick="history.back()"> 
  				<input type="button" value="목록" class="btn" onclick="location.href='${conPath }/board/list.do?pageNum=${param.pageNum}'"> 
  			</td>
  		</tr>
  	</table>
  </form>
</body>
</html>