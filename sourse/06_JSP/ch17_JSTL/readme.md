# ✨jSTL
- JSP는 HTML 태그와 같이 사용되어 코드 가독성이 떨어진다.
- 이러한 단점을 보완하고자 만들어진 라이브러리

## ✔사용자(커스텀) 액션 태그
- 별도의 라이브러리를 설치하고 설정을 해야 사용가능하다
## ✔JSTL 라이브러리
### 1. core : 출력, 제어문, 반복문 같은 기능이 포함된 라이브러리
- `<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>`
    - core 태그의 prefix, uri 지정
  #### 1-1. forEach : 반복문 태그
  `<c:forEach items=“객체명” begin=“시작 인덱스” end=“끝 인덱스” step=“증감식” var=“변수명” varStatus=“상태변수”>`
  - begin-end 미지정 시 전체 출력
  - step 기본값 : 1
  - `varStatus=”status”` 선언 후 `forEach` 태그 안에 쓸 수 있는 속성
    - `${status.current}` : 현재 아이템 
    - `${status.index}` : 0부터의 순서
    - `${status.count}` : 1부터의 순서
    - `${status.first}` : 현재 루프가 처음인지 반환
    - `${status.last}` : 현재 루프가 마지막인지 반환
    - `${status.begin}` : 시작값
    - `${status.end}` : 끝값 
    - `${status.step}` : 증가값 
  #### 1-2. set : 변수설정태그
  `<c:set var=“변수명” value=“설정값” target=“객체” property=“값” scope=“범위”>`  
  - 어떤 객체의 속성값을 변수로 지정

  #### 1-3. if : 조건 태그
  ```
  <c:if test="조건"> 
    조건 만족시 실행할 것
  </c:if>
  ```
  #### 1-4. choose : 여러 조건 걸기
  방문횟수에 따른 멘트 출력, `choose`에 없는 조건시 `otherwise` 출력
  ```
  <c:choose> 
  	<c:when test="${visitNum eq 1}">
  		첫 방문 감사
  	</c:when>
    <c:when test="${visitNum >1 && visitNum <=5}">
  		자주 방문해주세요
  	</c:when>
  	<c:otherwise>
			제대로 된 방문 횟수를 받지 못했습니다.
		</c:otherwise>
  </c:choose>
  ```
  #### 1-5. catch : 예외 처리 태그
  ```
  <c:catch var="변수명">	<!-- 예외 발생시 에외타입, 메세지가 변수에 저장 -->
		${8/0 } 
		<p>예외가 발생되는 즉시 catch 절 빠져나감. p태그 출력시 예외가 발생 안된것</p>
    <%=8/0%>  <!-- 예외 발생-->
	</c:catch>
  <c:out value="${e }" default="예외 발생 안됨"/> 
  <!-- 예외 메세지 : java.lang.ArithmeticException: / by zero -->
  ```
  #### 날짜 출력
  ```
  <c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
  => 2023-03-06   sql Date: 년, 월, 일
  <c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
  => 2023-03-06 22:06:27.093  Timestamp: 밀리타임까지 출력
  <c:set var="nowDateUtil" value="<%=new java.util.Date() %>"/>
  => Mon Mar 06 22:06:27 KST 2023   util Date
  ```
---
### 2. fmt : 국제화/형식화 액션. 국제화/형식화 기능을 제공해 주는 JSTL 라이브러리
`<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>` 선언  
#### 2-1 requestEncoding : 언어 세팅 태그
- `<fmt:requestEncoding value="utf-8"/>` : utf-8로 언어 세팅

#### 2-2 formatNumber : 숫자 형식 설정 태그
-  : `<fmt:formatNumber value="3333.149" pattern="#,###.##"/>`
  - value : 출력할 숫자
  - pattern : value의 패턴 지정
    - #으로 지정시 출력할 숫자보다 #이 더 많을 시 미출력
    - 0으로 지정 시 출력할 숫자보다 0이 더 많을 시 0으로 출력  
    -> `value="3.14" pattern="00.000"` = 03.140
#### 2-3. formatDate : 날짜 형식 설정 태그
- `<fmt:formatDate value="날짜" type="날짜 또는 시간" dateStyle="출력할 형식"/>`
  - `type` : `date`의 `dateStyle` 
    - `short` : 23. 3. 6  
    - `medium` : 2023. 3. 6
    - `long` : 2023년 3월 6일 (월)
    - `full` : 2023년 3월 6일 월요일
  - `type` : `time`의 `dateStyle` 
    - short : 오후 10:06
    - medium : 오후 10:06:27
    - long : 오후 10시 06분 27초
    - full :오후 10시 06분 27초 KST
  - type : both는 날짜와 시간 동시 출력
  - `pattern` : 정해진 형식이 아닌 사용자 지정 형식  
  `pattern="yyyy년 MM월 dd일(E) HH:mm:ss"` : 2023년 03월 06일(월) 22:06:27

### 3. functions : fn 라이브러리는 el 표기법과 함께 사용
- id 파라미터를 대문자로 : `${fn:toUpperCase(param.id) }`

