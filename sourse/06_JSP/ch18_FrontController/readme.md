# ✨Front Controller와 Command 구조
## ✔Front Controller : servlet 통합하기
- 요청을 처리하는 서블릿을 각각 만들면 서블릿이 너무 많아진다 => 개발, 유지보수 어렵다  
- 따라서 모든 요청을 처리하는 서블릿 `FrontController`를 만들어서 처리  
- 개발 및 유지보수의 효율성 극대화

### 통합 servlet 만들기
- 생성시 `url mapping` : *.do
- 들어온 요청 판별(insert.do?, select.do?, update.do?, delete.do?) 후 수행, view 로 `forward`
  - `uri`에서 `conPath` 빼기 : `substring` 이용
  - `command` 변수로 지정 : `String command = uri.substring(conPath.length());`
#### 요청 처리하는 class 생성
- `servlet`에서 다 처리하기엔 코드가 매우 길어지므로 각각 요청에 따른 `command class` 생성
- `method`는 통일
- 각 클래스들은 `interface`를 `implements` 받는다

#### interface 생성
`public void execute(HttpServletRequest request, HttpServletResponse response);`