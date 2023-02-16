# ✨JAVA 빈태그(bean)
## ✔ 빈이란
- 반복적인 작업을 효율적으로 하기 위해 사용. 
- JAVA 언어의 데이터(속성)와 기능(메소드)으로 이루어진 클래스
- jsp페이지를 만들고, 액션태그를 이용하여 빈을 사용한다. 그리고 빈의 내부 데이터를 처리한다

## ✔ 빈 만들기
- 데이터 객체를 만들기 위해 클래스를 만든다
- 대게 변수, 매개변수 없는 생성자, 매개변수 있는 생성자, getter&setter로 구성

## ✔ 빈 관련 액션태그
### 1. useBean : 특정 bean 사용한다고 명시
`<jsp:useBean id="객체이름" class="클래스명" scope="사용범위" />`
#### scope의 종류
- `page` : 빈이 생성된 페이지 내에서만 사용 가능
- `request` : 요청된 request 범위 내에서만 사용 가능
- `session` : 하나의 웹 브라우저 당 1개의 session객체 생성. 웹브라우저 생명주기와 동일하게 사용 가능
- `application` : 하나의 웹어플리케이션 당 1개의 application 객체 생성. 웹 어플리케이션 생명주기와 동일하게 사용

### 2. setProperty : 데이터 값을 설정할 때 사용. 자바에서의 setter역할
`<jsp:setProperty name="" property="" value=""/>`

### 3. getProperty : 데이터 값을 가져올 때 사용. 자바에서의 getter 역할
`<jsp:getProperty name="" property="" />`

## ✔ 실전
1. bean 파일 만들기
2. 데이터를 받을 파일(html)
3. 프로세스 파일(jsp)
```
<jsp:useBean id="id명" class="bean의 클래스명(ex. com.lec.ex.aaa)" scope="request"/>  // 사용범위 : request
<jsp:setProperty property="*" name="s"/>	// * : 전부를 의미
<jsp:forward page="studentView.jsp"/>       // View 페이지로 보내기
```    
4. 뷰 파일(jsp, 결과 파일)
```
<jsp:useBean id="id명" class="클래스명" scope="request"/>   // bean을 사용
<%=id명.get데이터명() %>    // 표현식을 이용하여 bean에서 얻은 데이터 사용 get다음 첫 글자는 대문자
```