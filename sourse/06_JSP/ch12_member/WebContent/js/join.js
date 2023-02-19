		const infoConfirm = function () {
			var patternMail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;	// match함수 사용
			if(join_frm.id.value.length < 3){	// 아이디 3글자이상
				alert('아이디를 3글자 이상 입력해주세요');
				join_frm.id.focus();
				return;
			}
			if(! join_frm.pw.value){
				alert('비밀번호를 입력해주세요');
				join_frm.pw.focus();
				return;
			}
			if(join_frm.pw.value != join_frm.pwChk.value){
				alert('비밀번호가 일치하지 않습니다');
				join_frm.pw.value = '';
				join_frm.pwChk.value = '';
				join_frm.pw.focus();
				return;
			}
			if(!join_frm.name.value){
				alert('이름을 입력해주세요');
				join_frm.name.focus();
				return;
			}
			if(join_frm.email.value && !join_frm.email.value.match(patternMail)){
				alert('메일 형식을 확인하세요');
				join_frm.email.focus();
				return;
			}
			join_frm.submit();	// 강제로 submit 이벤트 발생
		};