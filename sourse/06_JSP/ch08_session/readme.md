# ✨세션(session)
- jsp 파일에서는 session이 내장객체라서 바로 사용가능. 
- 자바(,서블릿)에서 session 사용하기 : `HttpSession 세션명 = request.getSession();`

## ✔세션이란
- 서버와의 관계를 유지하기 위한 수단
- 세션은 서버상에 객체로 존재. 웹컨테이너에 정보를 저장할 수 있는 내장 객체 변수이다
- 세션 객체는 자동적으로 만들어진다
- 객체를 추가 할 수 있다
- 서버에 저장되기에 보안이 좋고(java로만 접근 가능) 데이터의 한계가 없다

## ✔ 세션문법
### (1) 세션은 클라이언트의 요청이 발생하면 서버 컨테이너에서 자동생성된다. 그리고 session이라는 내부 객체를 지원하여 세션의 속성을 설정할 수 있다.

### (2) 세션 관련 method
- `setAttribute()` : 세션에 데이터를 저장
- `getAttribute()` : 세션에서 데이터를 얻는다.
- `getAttributeNames()` : 세션에 저장되어 있는 모든 데이터의 이름(유니크한 키값)을 얻는다.
- `getId()` : 자동 생성된 세션의 유니크한 아이디를 얻는다.
- `getMaxInactiveInterval()` : 세션의 유효시간을 얻는다. 가장 최근 요청시점을 기준으로 카운트 된다.
(C:\webPro\IDE\apache-tomcat-9.0.63\conf\web.xml 참조 디폴트 유효기간은 30분으로 설정됨.   
이것을 수정하면 유효시간이 수정될 수 있다)
- `removeAttribute()` : 세션에서 특정 데이터 하나 제거
- `invalidate()` : 세션의 모든 데이터를 삭제

### (3) 세션 사용 예제
#### ✔ JSP 파일에서는 session이 내장객체이므로 바로 사용이 가능
#### ✔ java, sublet에서 session 사용하기 : `HttpSession 세션명 = request.getSession();` 
- 세션에 데이터 저장(세션에 속성 추가) : `session.setAttribute(세션속성이름, 세션값)`
- 세션의 속성 가져오기 : `session.getAttribute(세션속성이름)`
- 모든 세션의 속성 가져오기
```
Enumeration<String> sAttrNames = session.getAttributeNames();   // 모든 세션 
	while(sAttrNames.hasMoreElements()){    // while문 이용하여 세션 출력
		String sname = sAttrNames.nextElement();   // 세션속성 이름
		String svalue = session.getAttribute(sname).toString(); // 세션값 : toString()으로 형변환
		out.println("<h2>" + sname + "(세션속성 이름) : " + svalue + "(세션값</h2>)");
	}
```        
- 세션 삭제 : `session.removeAttribute("세션속성 이름")`




## 회원가입 시 약관동의
- 거부시 세션 날리기
- 동의시 세션 받아서 DB에 넣기
- 가입완료 후 ID 세션만 남겨 로그인 시 회원가입한 아이디 자동 입력
- 로그인 후 로그인 페이지가 나오지 않게 하기(ID나 name 세션이 있다면 로그인 된 페이지로 보내기)

## 순서
1. 회원가입
2. 약관동의
3. 약관 동의 거부
4. 회원가입 결과
5. 로그인
6. 로그인 처리
7. 로그아웃
8. 메인페이지