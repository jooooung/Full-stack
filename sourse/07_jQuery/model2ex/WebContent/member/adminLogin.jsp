<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty member }">
		<script>
			alert('사용자는 관리자 모드로 로그인 할 수 없습니다');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty admin }">
		<script>
			alert('이미 로그인 하셨습니다');	
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<form action="adminLogin.do" method="post">
	  	<table>
	  		<caption>관리자로그인</caption>
	  		<tr>
				  <th><label for="aid">ID</label></th>
					<td>
						<input type="text" name="aid" id="aid" class="aid" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="apw">PW</label></th>
					<td>
						<input type="password" name="apw" id="apw" class="apw" required="required">
					</td>
				</tr>
	  		<tr>
	  			<td colspan="2">
	  				<input type="submit" value="로그인" class="btn">
	  				<input type="button" value="회원가입" class="btn"
	  							 onclick="location.href='${conPath}/joinView.do'">
	  			</td>
	  		</tr>
	  	</table>
	  </form>
	</div>  
	<jsp:include page="../main/footer.jsp" />
</body>
</html>