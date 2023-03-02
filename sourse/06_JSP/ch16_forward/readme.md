# ✨forward
- 내가 받은 요청을 내가 처리하지 않고 다른 쪽으로 위임해 버릴 때 그것을 포워드 한다고 한다.
- 
## ✔RequestDispatcher 클래스 
-  요청객체(request)를 위임하는 컴포넌트에 동일하게 전달할 수 있다
```
request.getRequestDispatcher("폴더명/파일명");
	dispatcher.forward(request, response);
}
```

## ✔HttpServletResponse 클래스
- RequestDispatcher 클래스와 동일하게 요청을 위임하는 클래스.
- RequestDispatcher  클래스와 차이점 : 요청 받은 요청객체(request)를 위임 받은 컴포넌트에 전달 하는 것이 아닌, 새로운 요청객체(request)를 생성