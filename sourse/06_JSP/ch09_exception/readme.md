# ✨예외페이지
## 예외페이지의 필요성
- 특정 상황에서 예외 발생시 프로세스가 멈추면 안되니 예외페이지를 걸어놓는다
- 예외 페이지는 내 페이지 내에서나 web.xml에다 걸 수 있다

## 페이지 내에서 에러 걸기
1. 에러가 날 만한 페이지에서 선언문을 이용하여 에러페이지로 이동 : `<%@ page errorPage = '에러해결파일' %>`
2. 에러해결파일
```
<%@ page isErrorPage="true" %>  // isErrorPage의 값을 true로 설정
<% response.setStatus(200); %>  // 기본 설정을 200으로 (정상)

 body에 표시할 에러 페이지 문구 표시
```

## web.xml에서 에러 걸기
```
<error-page>
    <error-code>에러코드</error-code>
    <location>에러코드의 에러페이지 파일</location>
</error-page>
```

## 프로젝트 팁
- 예외페이지 넣기
- 관리자용 페이지 따로 만들기