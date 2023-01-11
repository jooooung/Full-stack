# HTML - II
## ✨form(입력양식)태그
- form은 사용자에게 입력받는 공간으로 입력양식을 만들 때 사용하는 태그
- 입력 양식에 입력된 내용은 서버로 전송되어 구현된 웹 응용 프로그램이 구동되어 데이터베이스와 연동된다
## ✨입력양식의 type들
  ``` <form action="http://www.naver.com" method="get">```
1. action : 입력 데이터의 전달 위치를 지정
2. method: 입력 데이터의 전달 방식을 선택 
  - get : url에 포함되어 전송(query String 형식)  
  <name=”n1”/><name=”n2”/>일 때, url에 “?n1=value&n2=value”에 추가하여 
  - post : 입력한 데이터가 눈에 보이지 않게 전송(url이 아니라 데이터 영역을 이용해서 데이터를  
  전송하기에 웹브라우저나 서버 상관없이 파라미터 길이 제한이 없다)   
3. button : 버튼을 생성  
`<input type="button" value="button" />` <input type="button" value="button" />    
4. checkbox : 체크박스을 생성  
    - checked="checked" : 기본 체크값을 설정  
    - 중복체크, 미체크 가능

<input type="checkbox" name="lang" value="kor" checked="checked" />한국어
<input type="checkbox" name="lang" value="eng" />영어
<input type="checkbox" name="lang" value="chi" />중국어
```
<input type="checkbox" name="lang" value="kor" checked="checked" />한국어
<input type="checkbox" name="lang" value="eng" />영어
<input type="checkbox" name="lang" value="chi" />중국어
```

5. file : 파일 입력 양식을 생성  
`<input type="file" name="img" />` <input type="file" name="img" />
6. hidden : 보이지 않게 합니다.  
`<input type="hidden" name="hiddenParam" value="hidden전송값" />`
7. image : 이미지 형태를 생성
8. password : 비밀번호 입력 양식을 생성  
`<input type="password" name="pw" />` <input type="password" name="pw" />
9. radio : 라디오 버튼을 생성(기본값:circle)
   - name을 똑같이 설정해야 중복 선택이 불가해진다
<input type="radio" name="결혼" value="기혼" id="기혼" />기혼
<input type="radio" name="결혼" value="미혼" id="미혼" />미혼
```
      <input type="radio" name="결혼" value="기혼" id="기혼" />기혼
      <input type="radio" name="결혼" value="미혼" id="미혼" />미혼
```                  
10. reset : 초기화 버튼을 생성(입력값 초기화)  
`<input type="reset" value="초기화" />` <input type="reset" value="초기화" />
11. submit : 제출 버튼을 생성(value기본값 : 제출)  
`<input type="submit" value="로그인" />` <input type="submit" value="로그인" /> 
12. text : 글자 입력 양식을 생성(name, size 등 설정가능)  
`<input type="text" name="id" size="9" />` <input type="text" name="id" size="9" />
13. autofocus : 포커스 자동 설정(하나만 설정 가능)  `autofocus="autofocus"`
14. placeholder : 각 필드에 대한 입력 형식 힌트제공  
전화 <input type="tel" name="tel" placeholder="000-0000-0000" />  
`전화 <input type="tel" name="tel" placeholder="000-0000-0000" />`  
15. required : 필수 입력 필드
    - 미입력시 입력란을 작성하라는 말풍선이 뜬다
16. min, max : 숫자의 범위를 설정  
`<input type="number" name="career" max="60" min="0" />`
<input type="number" name="career" max="60" min="0" />
17. pattern : 조건을 사용한 일반식 표시  
    - pattern에 맞지 않게 입력 시 형식에 맞게 입력하라는 말풍선이 뜬다  
      title은 추가 설명
```
    <li>연락처 
	    <input type="text" name="tel" placeholder="000-0000-0000/00-000-0000"
		        pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}"	
			    title="전화번호 형식을 지켜주세요"
			    required="required"/>	<!--미입력 불가-->
	</li>
```        

✨18. label
- 입력창이 아닌 라벨을 클릭해도 입력창으로 이동되게 하기  
 <label for="name">이 &nbsp; 름 <strong>*</strong></label>
 <input type="text" name="name" id="name" required="required"
                 autofocus="autofocus" />
```
    <li>    
        <label for="name">이 &nbsp; 름 <strong>*</strong></label>   
        <input type="text" name="name" id="name" required="required"
          autofocus="autofocus" />
    </li>
```        
✨19. readOnly, disable
- readOnly : 입력불가, 읽기전용
- disable : 출력은 되나 전송안됨  
disable data <input type="text" disabled="disabled" name="disabledParam" value="disable값은 전송안됨"/>  
        readOnly data <input type="text" readonly="readonly" name="readonlyParam" value="readonly전송값" />
```
disable data <input type="text" disabled="disabled" name="disabledParam" value="disable값은 전송안됨"/>
readOnly data <input type="text" readonly="readonly" name="readonlyParam" value="readonly전송값" />
```        

### ✨유효성 검사
- 검사 순서는 태그 > javaScript  (따라서 통일해주는게 좋다)
- 태그 : `<input required="required">`
- javaScript
```
<script>
        function chk() {
            if (frm.id.value.length < 4) {  
                alert('아이디는 4글자 이상 필수입력입니다');  // 4글자가 안되면 오류 메세지 뿌리기
                frm.id.focus();  // id로 커서 이동
                return false;
            } else if (!frm.pw.value) {
                alert('비밀번호를 입력하세요');
                frm.pw.focus();
                return false;
            } else if (frm.pw.value != frm.pwChk.value) {
                alert('비밀번호를 확인하세요');
                frm.pw.value = '';
                frm.pwChk.value = '';
                frm.pw.focus();
                return false;
            }
            return true;
        }
    </script>
```

### ✨블록형태그, 라인형태그
- 블록형태그   
: 항상 새로운 줄에 태그가 생성된다  
: 오른쪽에 공간이 있어도 새로운 태그는 다음 줄에 생성  
`<header>, <section>, <footer>, <div>, <ul>, <ol>, <h1>`
- 라인형태그  
: 한 줄에 태그가 생성된다  
: 라인 태그에 기본 좌우 공백이 있기에 연속 사용시 태그 사이에 공간이 생긴다  
`<a>, <span>, <button>, <input>, <img>, <video>, <audio>`

### 시멘틱태그
- 사이트의 구조를 설계하기 위한 태그
- `<header>` 머리글, 제목
- `<nav>` 목차, 리스트
- `<section><content>` 정보부분 
- `<footer>` 바닥글, 문서 하단에 들어가는 정보(주소, 번호, 저작권 등)
