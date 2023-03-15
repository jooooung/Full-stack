<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/join.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  	$(function(){
  		$('#id').keyup(function(){
  			var id = $(this).val();
  			if(id.length < 2){
  				$('#idConfirmResult').text('아이디는 2글자 이상');
  			}else{
  				$.ajax({
  					url : '${conPath}/midConfirm.do',
  					type : 'get',
  					data : 'mid='+id,
  					dataType : 'html',
  					success : function(data){
  						$('#idConfirmResult').html(data);
  					},
  				});	// $.ajax
  			}  // if
  		}); // keyup
  		
  		$('#pw, #pwChk').keyup(function(){
  			var pw = $('#pw').val();
  			var pwChk = $('#pwChk').val();
  			if(pw == pwChk){
  				$('#pwChkResult').text('비밀번호 일치');
  			}else{
  				$('#pwChkResult').text('비밀번호 불일치');
  			}  // if
  		}); // keyup
  		
  		// 사용가능한 ID입니다(#idConfirmResult), 비밀번호 일치(#pwChkResult) 일 때만 submit
  		$('form').submit(function(){
  			var idConfirmResult = $('#idConfirmResult').text().trim();
  			var pwChkResult = $('#pwChkResult').text().trim();
  			if(idConfirmResult != '사용가능한 ID입니다'){
  				alert('사용 가능한 ID가 아닙니다');
  				return false;		// submit 제한
  			}else if(pwChkResult != '비밀번호 일치'){
  				alert('비밀번호를 확인하세요');
  				$('#pw').focus();
  				return false;		// submit 제한
  			}
  		});
  	});
  </script>
  <script>
  $( function() {
	  $( "#datepicker" ).datepicker({
	    	dateFormat: "yy-mm-dd",
	    	monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    	dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토" ],
	    	changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
	    	changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
	    	showMonthAfterYear: true,
	    	yearSuffix: '년',
	    	showOtherMonths: true, // 현재 달이 아닌 달의 날짜도 회색으로 표시
	    	//minDate: '-100y',	 // 현재날짜로부터 100년이전까지 년을 표시한다.
	    	maxDate: 'y', // 'y' 또는 0 : 지금 이전의 날짜만 선택
	    	yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 
	    	onSelect : function(dateText, inst){
	    		$('.reservedDate').val(dateText); // 2023-04-01
	    		$('span.result').html(dateText + "일 / 시간 : ");
	    		$('.reservedTime').val(''); // 선택한 시간들 초기화
	    		for(var i=0 ; i<=23 ; i++){
	    			$('#'+i).attr('disabled', false);
	    			$('#'+i).css('color','#000000'); 
	    		} // for - 날짜가 바뀔 때마다 시간을 다시 클릭할 수 있도록 셋팅
	    		// dateText가 오늘인지
	    		var today = new Date(); // 지금
	    		var year = today.getFullYear(); // 2023
	    		var month = String(today.getMonth()+1); // "0"+"3" => "03"
	    		if(month.length == 1){
	    			month = "0" + month;
	    		}
	    		var day = String(today.getDate());
	    		if(day.length == 1){
	    			day = "0" + day;
	    		}
					var todayStr = year+"-"+month+"-"+day;
					for(var i=0 ; i<= today.getHours() ; i++){
						$('#'+i).attr('disabled', true);
						$('#'+i).css('color', '#cccccc');
				} // if
			}, // onSelect
    }); // datepicker
  });
  </script>
</head>
<body>
	<div id="joinForm_wrap">
		<form action="">
			<div id="join_title">
				회원가입
			</div>
				<table>
					<tr>
						<th><label for="id">아이디</label></th>
						<td>
							<input type="text" name="id" id="id" class="id" required="required">
							<div id="idConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
						</td>
					</tr>
					<tr>
						<th><label for="pw">비밀번호</label></th>
						<td>
							<input type="password" name="pw" id="pw" class="pw">
						</td>
					</tr>
					<tr>
						<th><label for="pwChk">확인비밀번호</label></th>
						<td>
							<input type="password" name="pwChk" id="pwChk" class="pwChk">
							<div id="pwChkResult"> &nbsp; &nbsp; &nbsp; </div>
						</td>
					</tr>
					<tr>
						<th><label for="name">이름</label></th>
						<td>
							<input type="text" name="name" id="name" class="name">
						</td>
					</tr>
					<tr>
						<th><label for="birth">생년월일</label></th>
						<td>
							<input type="text" name="birth" id="datepicker" class="birth">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="가입하기" class="joinBtn_style">
							<input type="reset" value="다시하기" class="joinBtn_style">
							<input type="button" value="로그인" class="joinBtn_style">
						</td>
					</tr>
				</table>
		</form>
	</div>
</body>
</html>