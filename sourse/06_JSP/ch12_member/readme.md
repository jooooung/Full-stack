# ✨효율적인 데이터베이스 관리 – 회원인증 프로그램
## 테이블 설계하기
- 로그인    
- 회원가입
- 회원정보 수정
- 메인
- 로그아웃

- `CLOB` : 글자수 제한 없는 데이터 타입( 게시판 테이블 설계시)
- 데이터 입력시 이름의 두번째 글자까지는 소문자로
- DTO 생성시 생성자, getter&setter를 수동으로 만들었지만 요즘은 @ 어노테이션을 사용
## SQL
- DDL, DML 따로 만들기

modify.jsp
// 정보수정 페이지에서 로그인시 main페이지가 아닌 정보수정 페이지로 가게 하기
`response.sendRedirect("login.jsp? method=modify");` : modify 메소드 넘기기

login.jsp

```
<!-- modify 에서 로그인 시 modify 페이지로 보내기 위한 input -->
    <input type="hidden" name="method" value="<%=request.getParameter("method")%>">
```

loginOk.jsp
`String method = request.getParameter("method");	// "null" 또는 "modify"` : 메소드 받기
```
    if(method.equals("null")){		
			response.sendRedirect("main.jsp");
		}else{	// 정보수정 로그인 시 정보수정 페이지로 가기
			response.sendRedirect(method + ".jsp");;
		}
```            