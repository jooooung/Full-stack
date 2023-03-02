<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  	p {text-align: center;}
  	p:last-child {
			color: red;
			font-weight: bold;
		}
  </style>
</head>
<body>
  <form action="">
  	<p>
  		<input type="number" name="su1" value="<%=(int)(Math.random() * 9) + 1%>" readonly="readonly"> 
  		* 
  		<input type="number" name="su2" value="<%=(int)(Math.random() * 9) + 1%>" readonly="readonly"> 
  		= 
	  	<input type="number" name="result" >
	  	<input type="submit" value="확인">
  	</p>
  	<p>
  		${param.su1 } * ${param.su2 } =  ${param.result }
  		${param.su1 * param.su2 eq param.result ? "은(는) true 정답" : "은(는) false"} 
  	</p>
  </form>
</body>
</html>