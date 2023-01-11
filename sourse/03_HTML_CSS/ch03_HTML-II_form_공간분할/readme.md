# HTML - II
## ✨form(입력양식)태그
- form은 사용자에게 입력받는 공간으로 입력양식을 만들 때 사용하는 태그
- 입력 양식에 입력된 내용은 서버로 전송되어 구현된 웹 응용 프로그램이 구동되어 데이터베이스와 연동된다
## ✨입력양식의 type들
1. action : 입력 데이터의 전달 위치를 지정
2. method: 입력 데이터의 전달 방식을 선택 
  - get : url에 포함되어 전송(query String 형식)  
  <name=”n1”/><name=”n2”/>일 때, url에 “?n1=value&n2=value”에 추가하여 
  - post : 입력한 데이터가 눈에 보이지 않게 전송(url이 아니라 데이터 영역을 이용해서 데이터를  
  전송하기에 웹브라우저나 서버 상관없이 파라미터 길이 제한이 없다)
3. button : 버튼을 생성
4. checkbox : 체크박스을 생성
5. file : 파일 입력 양식을 생성
6. hidden : 보이지 않게 합니다.
7. image : 이미지 형태를 생성
8. password : 비밀번호 입력 양식을 생성
9. radio : 라디오 버튼을 생성(기본값:circle)
   - name을 똑같이 설정해야 중복 선택이 불가해진다
```
    <td>
      <input type="radio" name="결혼" value="기혼" id="기혼" />기혼
      <input type="radio" name="결혼" value="미혼" id="미혼" />미혼
    </td>
```                    
10. reset : 초기화 버튼을 생성
11. submit : 제출 버튼을 생성(기본값 : 제출)
12. text : 글자 입력 양식을 생성
13. autofocus : 포커스 자동 설정
14. placeholder : 각 필드에 대한 입력 형식 힌트제공
15. required : 필수 입력 필드
16. min, max : 숫자의 범위를 설정
17. pattern : 조건을 사용한 일반식 표시
```
                <li>연락처 
					<input type="text" name="tel" placeholder="000-0000-0000/00-000-0000"
						   pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}"	<!-- 패턴 설정-->
						   title="전화번호 형식을 지켜주세요"
						   required="required"/>	<!--미입력 불가-->
				</li>
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

✨18. label
- 입력창이 아닌 라벨을 클릭해도 입력창으로 이동되게 하기
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
```
disable data <input type="text" disabled="disabled" name="disabledParam" value="disable값은 전송안됨"/>
<br />
readOnly data <input type="text" readonly="readonly" name="readonlyParam" value="readonly전송값" />
<br />
```

### ✨블록형태그, 라인형태그
- 블록형태그
  - `<p></p>`
  - `<li></li>`
  - `<div></div>`
- 라인형태그
  - `<span></span>`

### 시멘틱태그
- `<header>`
- `<nav>`
- `<section>`
- `<footer>`
```
<body>
    <header>
        <h1>회사이름(헤더부분)</h1>
        <hr />
    </header>
    <nav>
        <ul>
            <li>메뉴1(네비게이션)</li>
            <li>메뉴2(네비게이션)</li>
            <li>메뉴3(네비게이션)</li>
        </ul>
        <hr />
    </nav>
    <section>
        <h3>What is HTML5 (정보부분=content, section)</h3>
        <p>
            피아니스트 임동혁이 전처와의 이혼소송 중 불거진 음란 사진 전송 의혹에 대해 무혐의 처분을 받았다.

            임동혁은 지난 10일 자신의 인스타그램 계정에 불기소 이유 통지서를 공개했다. 통지서에 따르면 서울중앙지검은 지난 달 27일 임동혁의 성폭력범죄의 처벌 등에 관한 특례법 위반(통신매체이용음란) 혐의에 대해 증거불충분을 이유로 무혐의 처분을 내렸다.

            무혐의 처분 후 임동혁은 “제가 그렇게 기다리고 기다리던 ‘이젠 말할 수 있다’ 그날이 왔다. 완벽하게 인격 살인을 당하고 또 그 와중에 저는 연주도 해야 했다. 너무나도 억을했지만, 저까지 언론 플레이를 하고 싶지 않았고, 음악가는 음악으로만 말해야 한다고 생각했다”고 말문을 열었다.

            이어 “진짜로 ‘가만히’ 있기는 하루하루가 매우 고통스러웠다. 제가 음악가로서 유일하게 할 수 있는 일은 연주를 더욱 더 잘하기 그리고 제가 앙코르를 평소보다 더 여러 개 하면서 트로이메라이 차이코프스키 사계 10월 등을 연주하면서 ‘이런 음악을 구사하는 사람’이 절대 성범죄자일리가 없다고 호소했던 것이다”라고 했다.
        </p>
        <hr />
    </section>
    <footer>
        <p>서대문구 141 | 네이버</p>
        <p>전화 02-111-1111 | 팩스 02-333-3333</p>
        <p>Copyright ⓒ naver corp. All Rights reserved</p>
    </footer>
</body>
```