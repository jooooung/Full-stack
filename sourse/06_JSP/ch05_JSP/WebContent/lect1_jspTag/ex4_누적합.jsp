<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		window.onload = function(){
			document.querySelector("form").onsubmit = function(){
				var num = document.querySelector('input[name="num"]');
				var n = Number(num.value.trim());
				if(isNaN(n) || n <= 0 || n%1 != 0){
					alert("자연수를 입력하세요");
					num.value = '';
					num.focus();
					return false;
				}
			};
		};
	</script>
</head>
<body>
<%
	String num = request.getParameter("num");
	if(num != null){
		num = num.trim();
	}
%>
	<fieldset>
		<legend>누적하고 싶은 수 입력</legend>
		<form action="">
			<%-- <input type="text" name="num" value="<%=num==null? "":num%>"> --%>
			<input type="text" name="num" value="<% 
																							if(num != null){
																								out.print(num);
																							}
																						%>">
			<input type="submit" value="누적결과">
		</form>
	</fieldset>
	<%
		if(num != null){
			int n = Integer.parseInt(num);	/* num이 String이므로 형변환 */
			int total = 0;	
			for(int i=1 ; i<=n ; i++){
				total += i;
			}
			out.println("<h2>1부터 " + n + "까지 누적합은 " + total + "입니다</h2>");
		}
	%>
</body>
</html>