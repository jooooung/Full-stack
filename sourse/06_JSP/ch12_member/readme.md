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
`response.sendRedirect("login.jsp?method=modify");` : modify 메소드 넘기기

modifyOk.jsp

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
---
---
## 커넥션 풀(DataBase Connection Pool)
- 클라이언트에서 다수의 요청이 발생할 경우 데이터베이스에 부하가 발생하게 된다
- 따라서 이러한 문제를 해결 하기 위해서 커넥션 풀(DataBase Connection Pool)기법을 이용
- 커넥션 풀 기법은 커넥션을 미리 만들어 놓는것이다
- server 프로젝트의 context.xml 파일에 
```
	<Resource 
		auth="Container"
		driverClassName = "oracle.jdbc.driver.OracleDriver"
		url = "jdbc:oracle:thin:@localhost:1521:xe"
		username = "scott"
		password = "tiger"
		name = "jdbc/Oracle11g" 	<!-- 커넥션 풀 이름 -->
		type = "javax.sql.DataSource"
		maxActive = "20"
		maxWait = "1000"	<!-- 최대대기시간 -->
	/>
```
- 추가 후 이클립스의 서버폴더와 컴퓨터의 톰캣폴더와 동기화 하기(서버 끄고 실행) : 서버탭에서 publish to the server 클릭
	- 서버 옆에 synchronized 뜨면 동기화 완료

## 커넥션 풀 만들기
```
	private Connection getConnection() throws SQLException {
		Connection conn = null;
//		커넥션 풀의 DateSourse안의 conn객체를 리턴
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");	  
							// 강제형변환
			conn = ds.getConnection();	// DataSource안의 conn 가져오기
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn; 
	}
```