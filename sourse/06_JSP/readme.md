# ✨JSP

- JSP는 Servlet과 반대로 HTML코드에 JAVA언어를 삽입하여 동적 문서를 만들 수 있다

## ✔ JSP 태그

1. 스크립트릿 `<%  %>` : JAVA 코드, 스크립트릿 내의 변수는 지역변수

   - 스크립트릿 내의 변수를 초기화하지 않으면 쓰레기 데이터가 된다

2. 지시자 `<%@  %>` : 페이지 속성을 지정할 때 사용, (page, include, taglib)
    - page : 해당 페이지의 전체적인 속성 지정. 주로 사용되는 언어 지정 및 import문을 많이 사용, 문서 타입(html, excel..)
    - include : 별도의 페이지를 현재 페이지에 사용 (footer 등 모든 페이지에서 반복되는 작업 등에 이용)  
      Ex) `<%@ include file="파일경로" %>`
    - taglib : 태그라이브러리(사용자가 만든 tag들)의 태그 사용. 태그라이브러리를 사용하기 위해 taglib지시자 사용.


3. 선언 `<%! %>` : 전역변수 및 메소드 선언
    - 선언부에서는 초기화하지 않아도 수는 0, 객체는 null로 자동 초기화
    - 브라우저를 꺼도 전역변수는 남아 있다

4. 주석 `<%-- --%>` : 응답 페이지에서는 이 주석은 보이지 않는다.  
    - WAS에서 이 주석은 제거하고 응답페이지를 만든다. 
    - cf. HTML 주석 : `<!-- -->`

5. 표현식 `<%=  %>` : 결과값 출력

6. 액션태그(jsp에서만 쓸 수 있는 태그)
   - `<jsp:action></jsp:action>` : 표준액션태그 ex.파일연결 및 자바빈 연결
   - `<c:set></c:set>` : 커스텀액션태그

## ✔ 내부객체
### request 객체 : 웹브라우저를 통해 서버에 어떤 정보를 요청하는 것
- request 객체의 메소드
    1. getRemoteAddr() : 웹서버에 연결한 클라이언트의 IP주소(예전에는 IPv4, 요즘은 IPv6)
    - `Ipv6` => `Ipv4로` 바꾸기 : eclipse > Run > Run Configurations > Apache Tomcat  
                             > Tomcat v9.0 Server >Arguiments >   
      Program arguments에 `-Djava.net.preferIPv4Stack=true` 입력  
      VM arguments:에 `-Djava.net.preferIPv4Stack=true` 입력


### response 객체 :  웹브라우저의 요청에 응답하는 것
- `getCharacterEncoding()` : 응답할때 문자의 인코딩.
- `addCookie(Cookie)` : 쿠키를 지정.
- `sendRedirect(URL)` : 지정한 URL로 이동
