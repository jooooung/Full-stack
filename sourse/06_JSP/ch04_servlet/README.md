# Servlet 웹 프로그래밍

## Servlet이란

- JSP 표준이 나오기 전에 만들어진 표준으로 자바에서 웹 애플리케이션을 개발할 수 있도록 하기 위해 만들어 졌으며 자바 클래스를 웹에서 실행 할 수 있도록 한 웹 프로그램
- java를 사용하여 웹페이지를 동적으로 생성하는 서버측 프로그램 또는 그 사양을 말한다
- 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종
- `javax.servlet.http.HttpServlet` 클래스로부터 상속받아서 작성
- 위의 클래스는 톰캣의 servlet-api.jar 에 포함
- form action에는 jsp나 servlet이 들어가야된다

### jsp와 servlet의 차이

- jsp : HTML 내에 java를 포함
- servlet : java 내에 HTML을 포함

## Dynamic Web Project의 폴더별 파일

- src 폴더 - java, DTO, DAO, servlet(java)
- WebContent 폴더 - HTML CSS JS JSP
- 보통 WebContent root에는 index.jsp 파일이 온다(다른 파일은 폴더 생성 후 폴더에 넣어 놓는다)

## url

- servlet은 브라우저를 띄우기 위한 url이 필요하다  
  => src 폴더 내에 servlet파일 생성 => package, Class name 지정  
  => next => URL mapping 이름 변경 => next => doget 확인 후 finish
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

## 파라미터 받아오기

- 파라미터를 받으면 무조건 String 으로 들어온다
- `request.getParameter("파라미터")` : 파라미터 하나 받기
- `request.getParameterValue("파라미터")` : 파라미터 하나 이상 받기(배열)

- 초기화 파라미터 : 한 서블릿에서만 쓸 수 있는 파라미터
## 공유 파라미터 : 내 프로젝트 내에서 쓸 수 있는 파라미터
```
<context-param>
  <param-name>contextId</param-name>
  <param-value>scott</param-value>
</context-param>
<context-param>
  <param-name>contextPw</param-name>
  <param-value>tiger</param-value>
</context-param>
```
### 공유 파라미터 불러오기 : `getServletContext().getInitParameter(파라미터명)` (파라미터명은 대소문자 구분)

# server
- servers 폴더의 server.xml 과 tomcat - conf 폴더의 server.xml은 수시로 동기화가 된다
- project 생성시 project명과 context root를 일치 시키는게 안전하다

# method
- `service` 를 override하면 doGet(), doPost() 함수가 실행되지 않고 service()함수 실행
- `init` : servlet 객체가 생성될 때 실행된다
- `destroy` : servlet 객체가 소멸될 때 실행된다

# 


# 팁

## 프로젝트에 web.xml 파일 없을 시

1. Deployment Descriptor 우클릭 - Generate Deployment Descriptor Stub 클릭
2. 다른 프로젝트에서 복사해오기 (`display-name`만 프로젝트명으로 변경하면 된다)

## 파일에 한글 안 깨지게 설정

- utf-8로 설정해주기 : `response.setContentType("text/html; charset=utf-8");`
