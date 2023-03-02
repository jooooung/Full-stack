# ✨EL(Expression Language) : 표현식 또는 액션태그를 대신해서 값을 표현

## ✔EL 이란

- 표현식(<%=~ %>)을 더 간략하게 대신하여 값을 표현하는 언어. 액션 태그를 조금 간략하게 표현한 것
- 표현식 (<%= value %> ) → EL 표기법(${ value })

## ✔EL 연산자

- 파라미터 받기 : param.파라미터

```
  <p>산술연산자 : 10 + 1 = ${10+1}</p>
  <p>산술연산자 : 10 / 0 = ${10/0}</p>
  <p>관계연산자 : 1 > 2  = ${1 gt 2}</p>
  <p>관계연산자 : 1 > 2  = ${1 > 2}</p>
  <p>관계연산자 : 1 == 2 = ${1 eq 2}</p>
  <p>관계연산자 : 1 != 2 = ${1 != 2}</p>
  <p>조건연산자 : ${(1>2)? "1이 2보다 큽니다" : "1이 2보다 크지 않습니다"}</p>
  <p>논리연산자 : (1>2) || (1&lt;2) = ${(1>2) || (1<2)}</p>	  <!-- &lt; = <  사용이유 <를 태그로 인식오류가 생길 수도 있어서-->
  <p>로그인 여부(eq) : ${customer eq null? "로그인 안함" : "로그인 함"}</p> <!-- (sessionScope).customer -->
  <p>로그인 여부(empty) : ${empty customer? "로그인 안함" : "로그인 함"}</p>
  <p>로그인 여부(not empty) : ${not empty customer? "로그인 함" : "로그인 안함"}</p>
  <p>pageNum 여부 : ${empty param.pageNum? "pageNum안 옴" : "pageNum 옴"}</p>
  <P>su파라미터 값 : ${param.su }</P>	<!-- EL에서는 "" -->
  <P>su파라미터 대문자 변경 : ${param.su.toUpperCase() }</P>		<!-- 오류가 나지 않는다 -->
```

## ✔EL 표기법을 이용한 정보출력

- DTO 생성 : getter 필수
- `<jsp:useBean id="member" class="com.lec.ex.Member" scope="page"/>` : 빈
- `${member.id }` : 자동으로 getId를 하여 가져온다

- bean 태그로 객체 생성 = 표현식, el 표기법에서 사용가능
- 자바에서 만든 객체 = 표현식에서만 사용 가능. el 표기법 사용시 에러는 안 나지만 값이 null("")

## ✔내장객체
### Scope에 관한 객체
- `Scope`객체는 생략 가능하다. 생략시 알아서 어떤 객체인지 찾아준다
ex) `session 내 attribute : ${sessionName }` : scope 객체를 생략했지만 `sessionName`인 `scope`객체를 알아서 찾아준다
1. `pageScope` : page객체의 attribute를 참조하는 객체(page attribute의 집합) Map 타입
2. `requestScope` : request객체의 attribute를 참조하는 객체(request attribute의 집합) Map 타입
3. `sessionScope` : session객체의 attribute를 참조하는 객체(session attribute의 집합) Map 타입
4. `applicationScope` : application객체의 attribute를 참조하는 객체(application attribute의 집합) Map 타입
### 그 외 유용한 객체
- `param` : 요청 파라미터를 참조하는 객체(웹 브라우저로부터 입력된 데이터의 집합) Map 타입
- `paramValues` : 요청 파라미터(배열)를 참조하는 객체(웹 브라우저로부터 입력된 데이터의 집합-똑 같은 이름의 데이터가 여럿일 때 사용) Map 타입
- `initParam` : `${initParam.파라미터명 }` => web.xml에 명시 후 사용