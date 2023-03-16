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
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<form action="login.do" method="post">
			<input type="hidden" name="next" value="${param.next }">
	  	<table>
	  		<caption>로그인</caption>
	  		<tr>
				  <th><label for="mid">ID</label></th>
					<td>
						<input type="text" name="mid" id="mid" class="mid" required="required" value="${mid }" >
					</td>
				</tr>
				<tr>
					<th><label for="mpw">PW</label></th>
					<td>
						<input type="password" name="mpw" id="mpw" class="mpw" required="required">
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