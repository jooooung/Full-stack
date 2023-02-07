<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		margin:0 auto;
		text-align: center;
	}
</style>
<script>
	window.onload = function () {
	  document.querySelector('form').onsubmit = function(){
		var su1 = document.querySelector('input[name="su1"]');
		var su2 = document.querySelector('input[name="su2"]');
		
		if(!su1.value){
			alert('첫번째 숫자를 입력해주세요');
			su1.focus();
			return false;
		} else if (!su2.value){
			alert('두번째 숫자를 입력해주세요');
			su2.focus();
			return false;
		} 
		var s1 = parseInt(su1.value);
		var s2 = parseInt(su2.value);
		if (s1 > s2){
			alert('작은 수부터 입력해주세요')
			return false;
		}
	  }
	}
</script>
</head>
<body>
	<form action="6_gugudan2Out.jsp" method="get">
	<p>단수 : <input type:"number" name="su1"> 단 ~ 
		<input type:"number" name="su2">단까지
	</p>
	<p><input type="submit" value="구구단 출력"></p>
	
	</form>
</body>
</html>