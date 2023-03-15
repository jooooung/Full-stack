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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  	$(function(){
  		$('#mid').keyup(function(){
  			var mid = $(this).val();
  			if(mid.length < 2){
  				$('#midConfirmResult').text('id를 2글자 이상 입력하세요')
  			}else{
  				$.ajax({
  					url : "${conPath}/midConfirm.do",
  					type : 'get',
  					data : 'mid='+mid,
  					dataType : 'html',
  					success : function(data){
  						$('#midConfirmResult').html(data);
  					},
  				}); // $.ajax
  			} // if
  		}); // #mid keyup event
  		
  		$('#mpw, #mpwChk').keyup(function(){
  			var mpw = $('#mpw').val();
  			var mpwChk = $('#mpwChk').val();
  			if(mpw != '' && mpwChk != '' && mpw == mpwChk){
  				$('#mpwChkResult').text('비밀번호 일치');
  			}else{
  				$('#mpwChkResult').html('<b>비밀번호 불일치</b>');
  			}  // if
  		}); // mpw, mpwChk keyup
  		
  		$('#memail').keyup(function(){
  			var memail = $(this).val();
  			if(memail){
  				$.ajax({
  					url : "${conPath}/memailConfirm.do",
  					type : 'get',
  					data : 'memail='+memail,
  					dataType : 'html',
  					success : function(data){
  						$('#memailChkResult').html(data);
  					},
  				}); // $.ajax
  			} // if
  		}); // #memail keyup event
  		
  	// submit : 사용가능한 ID입니다(#idConfirmResult), 비밀번호 일치(#pwChkResult) 일 때만 
  		$('form').submit(function(){
  			var midConfirmResult = $('#midConfirmResult').text().trim();
  			var mpwChkResult = $('#mpwChkResult').text().trim();
  			var memailChkResult = $('#memailChkResult').text().trim();
  			if(midConfirmResult != '사용가능한 ID입니다'){
  				alert('사용 가능한 ID가 아닙니다');
  				return false;		// submit 제한
  			}else if(mpwChkResult != '비밀번호 일치'){
  				alert('비밀번호를 확인하세요');
  				$('#mpw').focus();
  				return false;		// submit 제한
  			}else if(memailChkResult != '사용가능한 이메일입니다'){
  				alert('사용가능한 이메일이 아닙니다');
  				return false;   // submit 제한
  			} // if
  		}); // form submit event
  	});
  	
  	function checkSize(input) {
		    if (input.files && input.files[0].size > (3 * 1024 * 1024)) {
		        alert("용량이 3mb를 넘습니다.");
		        input.value = null;
		    }
		} // mphoto 업로드 용량 제한
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
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<form action="join.do" method="post" enctype="multipart/form-data">
			<table>
				<caption>회원가입</caption>
				<tr>
						<th><label for="mid">아이디</label></th>
						<td>
							<input type="text" name="mid" id="mid" class="mid" required="required">
							<div id="midConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
						</td>
					</tr>
					<tr>
						<th><label for="mpw">비밀번호</label></th>
						<td>
							<input type="password" name="mpw" id="mpw" class="mpw" required="required">
						</td>
					</tr>
					<tr>
						<th><label for="mpwChk">확인비밀번호</label></th>
						<td>
							<input type="password" name="mpwChk" id="mpwChk" class="mpwChk" required="required">
							<div id="mpwChkResult"> &nbsp; &nbsp; &nbsp; </div>
						</td>
					</tr>
					<tr>
						<th><label for="mname">이름</label></th>
						<td>
							<input type="text" name="mname" id="mname" class="mname" required="required">
						</td>
					</tr>
					<tr>
						<th><label for="memail">메일</label></th>
						<td>
							<input type="email" name="memail" id="memail" class="memail">
							<div id="memailChkResult"> &nbsp; &nbsp; &nbsp; </div>
						</td>
					</tr>
					<tr>
						<th><label for="mphoto">사진</label></th>
						<td>
							<input type="file" name="mphoto" id="mphoto" class="mphoto" onchange="checkSize(this)">
						</td>
					</tr>
					<tr>
						<th><label for="mbirth">생년월일</label></th>
						<td>
							<input type="text" name="mbirth" id="datepicker" class="mbirth">
						</td>
					</tr>
					<tr>
						<th><label for="maddress">주소</label></th>
						<td>
							<input type="text" name="maddress" id="maddress" class="maddress">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="회원가입" class="btn">
							<input type="button" value="로그인" class="btn">
						</td>
					</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>