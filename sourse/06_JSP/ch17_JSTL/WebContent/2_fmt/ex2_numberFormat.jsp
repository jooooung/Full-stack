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
</head>
<body>
	<c:set var="num" value="1234567.56" />
	<p>num : ${num }</p>
	<p>
		세자리 마다 , groupingUsed :
		<fmt:formatNumber value="${num }" groupingUsed="true" />
	</p>
	<p>
		세자리 마다 , pattern :
		<fmt:formatNumber value="${num }" pattern="#,###.#" />
		(# 소수점 둘째자리에서 반올림)
	</p>
	<p>
		세자리 마다 , pattern :
		<fmt:formatNumber value="${num }" pattern="#,###.##" />
		(#)
	</p>
	<p>
		세자리 마다 , pattern :
		<fmt:formatNumber value="${num }" pattern="#,###.000" />
		(소수점만 0)
	</p>
	<p>
		세자리 마다 , pattern :
		<fmt:formatNumber value="${num }" pattern="0,000.000" />
		(전체 다 0)
	</p>
	<c:set var="pi" value="3.14159"/>
	<p>
		pi : <fmt:formatNumber value="${pi }" pattern="#,###.########"/>	<!-- 없으면 생략된다 -->
	</p>
	<p>
		pi : <fmt:formatNumber value="${pi }" pattern="000.000000"/>  <!-- 없는거 만큼 0으로 채워진다 -->
	</p>
</body>
</html>