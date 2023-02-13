# ✨액션태그(action tag)
- JSP 페이지에서 어떤 동작을 하도록 지시하는 태그.
## ✔ 표준액션(standard action) 태그
    - JSP 페이지에서 바로 사용할 수 있는 태그

## ✔ 커스텀 액션(custom action) 태그
    - 별도의 라이브러리를 설치해야만 사용할 수 있는 태그

- 표준 액션 태그와 커스텀 액션 태그는 접두어가 다르기 때문에 외형상 쉽게 구분 가능  
`표준 액션 태그 : 이름 앞에 jsp라는 접두어` `커스텀 액션 태그 : 그 밖의 접두어`

## ✔액션태그
- 액션 태그는 XML 문법을 따르므로 단독 태그일 경우에는 반드시 ‘/>’로 끝나도록 만들어야 한다.

### forward
- 현재의 페이지에서 다른 특정페이지로 전환할 때 사용. URL은 변하지 않는다 
- 문법 : `<jsp: forward page="페이지경로"/>`

### include
- 현재 페이지에 다른 페이지를 삽입할 때 사용 
- 문법 : `<jsp:include page="삽입할 페이지"/> `

### param
- forward 및 include 태그에 데이터 전달을 목작으로 사용되는 태그. 이름과 값으로 구성
- 문법 : `<jsp:param value="" name="">`

### include에 param 활용하기
- include로 파일을 가져오는 동시에 param을 이용하여 원하는 데이터도 가져올 수 있다
```
<jsp:include page="파일">
	<jsp:param value="" name=""/>
	<jsp:param value="" name=""/>
	<jsp:param value="" name=""/>
</jsp:include>
```


