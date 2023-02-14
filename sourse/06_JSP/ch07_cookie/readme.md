# 🍪 쿠키
- 쿠키란 : 연결이 끊겼을 때 어떤 정보를 지속적으로 유지하기 위한 수단
- 쿠키는 서버에서 생성하여, 서버가 아닌 클라이언트측에 특정 정보를 저장(txt 파일 형태나 db파일 형태로 저장) 
- 서버에 요청 할 때 마다 쿠키의 속성값을 참조 또는 변경 할 수 있다 

## 쿠키의 단점
- 보안이 취약하다.(클라이언트 쪽에 저장되기 때문)
- 쿠키는 4kb로 용량이 제한적, 300개까지 데이터 정보를 가질 수 있다.

## ✔ 로그인시 쿠키 생성 경로
```
client(Server 로 요청(request)) -> web Server  -> WAS(Web Application Server)
                                    (jsp로 요청시 -> servlet)

   client            <- web Server (response)  <-   WAS  
String으로 쿠키 저장                            필요한 쿠키 생성
(크롬은 db 파일)                                    (300개이하)
```
- 로그인 시 생긴 쿠키는 정해놓은 조건 만족 시 없어진다. (시간, 로그아웃, 브라우저 닫을 시 등등)  
(WAS에서 같은 쿠키 생성하여 유효시간을 0으로 설정 후  client로 보내 원래 있던 쿠키에 덮어 씌워서 삭제)

## ✔쿠키 문법
- 쿠키 생성 : `Cookie cookie = new Cookie("cookieName", "cookieValue");`	// 쿠키 생성(이름, 값)
   - 같은 이름의 쿠키는 계속 생성해도 덮어씌워진다
- response 객체에 쿠키 탑재 : `response.addCookie()` 	(브라우저마다 저장 형식이 다르다 ex) chrome=db파일)

### 쿠키 관련 메소드
- `setMaxAge()` : 쿠키 유효기간을 설정(단위 : 초, -1 = 브라우저 닫을때까지)
- `setPath()` : 쿠키사용의 유효 디렉토리를 설정
- `setValue()` : 쿠키의 값을 설정
- `setVersion()` : 쿠키 버전을 설정
- `getMaxAge()` : 쿠키 유효기간 정보를 얻는다.
- `getName()` : 쿠키 이름을 얻는다.
- `getPath()` : 쿠키사용의 유효 디렉토리 정보를 얻는다.
- `getValue()` : 쿠키의 값을 얻는다.
- `getVersion()` : 쿠키 버전을 얻는다.

## ✔쿠키 확인하기
- 브라우저 F12 - application - 왼쪽 storage의 cookie 클릭

## ✔쿠키 리스트
- 쿠키를 가져온 후 for문을 이용하여 이름과 값을 지정 후  출력
```
<%
   Cookie[] cookies = request.getCookies();	// 쿠키 배열로 가져오기
	if(cookies != null){    // 쿠키가 null이 아닐 때
		for(int idx=0 ; idx<cookies.length ; idx++){
			String name = cookies[idx].getName();	// idx번째 쿠키의 이름
			String value = cookies[idx].getValue();	// idx번째 쿠키의 값
			out.println("<h2>" + idx + "번째 쿠키 이름 : " + name + ", 쿠키 값 : " + value + "</h2>");
		}
	}else{   // 쿠키가 null일 때
		out.println("<h2>해당 서버로부터 생성된 쿠키가 없습니다</h2>");
	}
%>
```   

## ✔특정 쿠키 찾기
```
   <%
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			int idx;
			for(idx=0 ; idx<cookies.length ; idx++){
				String name = cookies[idx].getName();	// idx번째의 쿠키 이름
				if(name.equals("찾을 쿠키명")){
					String value = cookies[idx].getValue();
					out.println("<h3>찾고자 하는 쿠키이름 : " + name + ", 값 : " + value + "</h3>");
					break;   // 찾았다면 break
				}// if
			}// for
			if(idx==cookies.length){
			out.println("<h3>찾는 쿠키가 없습니다</h3>");
			}
		}else{
			out.println("<h3>생성된 쿠키가 없습니다</h3>");
		}
   %>
```

## ✔쿠키 지우기
- 같은 이름의 쿠키를 유효시간을 0초로 생성 후 response 탑재
1. 쿠키가 있다면 쿠키(들) 가져오기
2. 쿠키의 name과 지울 쿠키 name이 같다면 같은 이름으로 쿠키 새로 만들기
3. 같은 이름의 새 쿠키의 유효시간 0초로 설정
4. 쿠키 추가 
```
   <%	// 같은 이름의 쿠키를 유효시간을 0초로 생성 후 response 탑재
			Cookie[] cookies = request.getCookies();  
			if(cookies != null){    // 1
				for(Cookie c : cookies){
					String name = c.getName();    // 2
					if(name.equals("cookieName")){
						Cookie cookie = new Cookie("cookieName", "xxx");	// 같은 이름의 쿠키 새로 만들기
						cookie.setMaxAge(0);	// 3. 유효시간 0초로 설정
						response.addCookie(cookie);   // 4	
						out.println("<h3>쿠키 삭제 성공</h3>");
						break;
					}// if
				}// for
			}// if
	%>
```

## 로그인/로그아웃 페이지 만들기
1. 헤더 : 기본 / 로그인 시 조건 걸어 기본 헤더, 로그인 시 헤더 설정
2. 메인 페이지 : 디폴트는 기본 헤더
3. 회원가입 : 유효성 검사, 입력 조건 설정
4. 회원가입 프로세스 : 회원가입에서 데이터 받아 DB에 저장
5. 로그인 : 로그인 실패 시 조건 / 성공 시 메인 페이지로 이동
6. 로그인 프로세스 : 로그인 페이지에서 id pw 데이터 받아 DB 연동하여 확인
7. 로그아웃 : 쿠키의 id 값 비교하여 쿠키 삭제 후 메인 페이지 이동
