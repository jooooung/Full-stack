

# Servlet

- form action에는 jsp나 servlet이 들어가야된다
- method가 post라면 => `request.setCharacterEncoding("utf-8");`
  `<%!String name, id, pw ; %>		<!-- 선언부에 선언된 변수는  null 값으로 자동초기화 -->`
## 폴더별 파일
- src 폴더 - java  
- WebContent 폴더 - HTML CSS JS JSP

- servlet은 브라우저를 띄우기 위한 url이 필요하다 => src 폴더 내에 servlet파일 생성 => package, Class name 지정 => next => URL mapping 이름 변경 => next => doget 확인 후 finish
- `response` : 응답하는 객체
- URL은 get방식으로 요청된다
- servlet URL 은 WebContent root에 있는 것과 동일

### web.xml 파일에서 url 맵핑하기
- 장점 : 어떤 servlet이 있는지 한 눈에 확인 가능
- 단점 : 오타나 오류 날 시 
```
<servlet>
    <servlet-name>HelloWorld</servlet-name>
    <servlet-class>com.lec.ex.Ex1_HelloWorld</servlet-class>
</servlet>
<servlet-mapping>
  	<servlet-name>HelloWorld</servlet-name>
  	<url-pattern>/HW</url-pattern>
</servlet-mapping>
```
## 스트림
- 파라미터를 받으면 무조건 String 으로 들어온다
- `PrintWriter out = response.getWriter();`
- `request.getParameter()` : 파라미터 하나 받아오기

## jsp와 servlet의 차이
### servlet
- servlet은 java 내에 jsp가 들어간다
- java로직을 많이 넣어야 할 때 사용
### jsp
- html 내에 java가 들어간다

# thread
- 하나의 프로그램에 동시에 여러가지 일을 하는 것

# 팁
- 프로젝트에 web.xml 파일 없을 시   
1. Deployment Descriptor 우클릭 - Generate Deployment Descriptor Stub 클릭
2. 다른 프로젝트에서 복사해오기 (`display-name`만 프로젝트명으로 변경하면 된다)

