# ✨jSTL
- `<jsp:~>` : 표준액션태그

## ✔사용자(커스텀) 액션 태그
- 별도의 라이브러리를 설치하고 설정을 해야 사용가능하다
### 1. core : 출력, 제어문, 반복문 같은 기능이 포함된 라이브러리
- `<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>` : 
    - core 태그의 prefix, uri 지정
#### 1-1. forEach : 반복문 태그
`<c:forEach items=“객체명” begin=“시작 인덱스” end=“끝 인덱스” step=“증감식” var=“변수명” varStatus=“상태변수”>`
#### 1-2. set : 변수설정태그
`<c:set var=“변수명” value=“설정값” target=“객체” property=“값” scope=“범위”>`  
어떤 객체의 속성값을 변수로 지정

#### 1-3. if : 조건 태그


---
### 2. fmt : 국제화/형식화 액션. 국제화/형식화 기능을 제공해 주는 JSTL 라이브러리
`<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>` 선언  
#### 2-1 requestEncoding : 언어 세팅 태그
- 

#### 2-2 formatNumber : 숫자 형식 설정 태그
-  : `<fmt:formatNumber value="3333.149" pattern="#,###.##"/>`
  - value : 출력할 숫자
  - pattern : value의 패턴 지정

### 3. functions : fn 라이브러리는 el 표기법과 함께 사용
- id 파라미터를 대문자로 : `${fn:toUpperCase(param.id) }`