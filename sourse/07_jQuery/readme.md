# Ajax : 서버와 데이터 교환을 하는 기술.
- 특정부분의 데이터 수정 시 전체 페이지를 로딩하지 않고 서버와 데이터 교환이 가능
- jQuery에서는 ajax관련 여러 메소드 제공
# Http Request : GET vs. POST
1. $.get(URL, callback);
2. $.post(URL, {파라미터이름:전달파라미터값, callback);
3. $.ajax
```
$.ajax({
	url : 요청 자원(서버)를 호출,
	type : 요청처리방식,
	data : 요청 시 함께 전달되는 데이터,
	dataType : 요청 후 응답의 결과로 반환되는 데이터 종류 ex)html, json, text,
	success : 성공했을 때 처리할 내용(콜백함수)
              function(data){},
	error : 응답 에러났을 때 에러 상태에 대한 코드 반환,
            function(code){
		  		code:에러에 대한 code 내용 전달
            }

});
```