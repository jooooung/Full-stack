# ✨forward
- 내가 받은 요청을 내가 처리하지 않고 다른 쪽으로 위임해 버릴 때 그것을 포워드 한다고 한다.
- forward 시 request 객체, 파라미터도 그대로 넘어간다
## ✔RequestDispatcher 클래스 
-  요청객체(request)를 위임하는 컴포넌트에 동일하게 전달할 수 있다
```
request.getRequestDispatcher("폴더명/파일명");
	dispatcher.forward(request, response);
```

## ✔HttpServletResponse 클래스
- RequestDispatcher 클래스와 동일하게 요청을 위임하는 클래스.
- RequestDispatcher  클래스와 차이점 : 요청 받은 요청객체(request)를 위임 받은 컴포넌트에 전달 하는 것이 아닌, 새로운 요청객체(request)를 생성

# dispatcher 방식
- 기존의 방식은 요청(jsp)시 처리(JSP(java)) 후 DAO로 가는 절차였다
- `<% %>` 내의 코드를 java로 빼고 출력하는 view를 분리한다
- form태그에 액션을 jsp가 아닌 servlet 파일로 가게 한다(디렉토리 구조) servlet 생성 시 url mappings 을 액션에 입력한 것과 일치시키기
- 프로세스는 java, view는 jsp에서 작성
- input.jsp 파일 => process.java(servlet) 파일 => view.jsp 파일 
---------
- response.sendRedirect 사용 시 request, 파라미터 전부 초기화   
따라서 `RequestDispatcher` 또는 `forward` 이용
```
RequestDispatcher dispatcher = request.getRequestDispatcher("폴더명/파일명");
dispatcher.forward(request, response);
```