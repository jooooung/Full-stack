# ✨액션태그(action tag)
- JSP 페이지에서 어떤 동작을 하도록 지시하는 태그.
## ✔ 표준액션(standard action) 태그
    - JSP 페이지에서 바로 사용할 수 있는 태그

## ✔ 커스텀 액션(custom action) 태그
    - 별도의 라이브러리를 설치해야만 사용할 수 있는 태그

- 표준 액션 태그와 커스텀 액션 태그는 접두어가 다르기 때문에 외형상 쉽게 구분 가능  
`표준 액션 태그 : 이름 앞에 jsp라는 접두어` `커스텀 액션 태그 : 그 밖의 접두어`

## ✔액션 태그
### 1. forward
- `response.sendRedirect()` : 새로 만들어져 요청된다. 새로운 request객체(주소창의 url이 바뀜)
- `<jsp:forward page="연결할 페이지"/>` : 현재의 페이지에서 다른 특정페이지로 전환할 때 사용.   
(주소창의 url이 안 바뀜(request객체가 그대로))
 
 ### 2. param
 - forward 및 include 태그에 데이터 전달을 목적으로 사용되는 태그. 이름과 값으로 구성.  
 `<jsp:param value="" name=""/>`

### 3. include
- `<jsp:include page="파일명"/>` : jsp파일의 결과 html을 include
- `<%@ include file="includedPage.jsp" %>` : jsp파일의 원본 그대로 include (conPath가 2개로 겹쳐서 오류가 난다)