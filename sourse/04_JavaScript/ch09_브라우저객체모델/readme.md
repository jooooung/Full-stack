# window 객체
- window 객체는 브라우저 기반 자바 스크립트의 최상위 객체이다.

## window 객체 생성 메소드
### open
- 문법 : `open(URL, name, features, (replace))`
1. URL : 열고자 하는 HTML 페이지의 URL
2. name : 윈도우 간 통신하는데 사용하는 윈도우 이름 또는 target속성
3. features : 윈도우 출력 모양을 지정하는 옵션(width, height 등)

### 새 창 위치조정
- moveTo(x, y) : 새 창의 위치를 절대적으로 이동
- moveBy(x, y) : 새 창의 위치를 상대적으로 이동
- resizeTo(x, y) : 새 창의 크기를 절대적으로 지정
- resizeBy(x, y) : 새 창의 크기를 상대적으로 지정
- scrollTo(x, y) : 새 창 스크롤의 위치를 절대적으로 이동
- scrollBy(x, y) : 새 창 스크롤의 위치를 상대적으로 이동
- focus() : 새 창에 초점 맞추기
- blur() : 새 창에 초점을 제거
- close() : 새 창을 닫는다


## screen
- 웹 브라우저의 화면이 아니라 운영체제 화면이 속성을 가지는 객체
- screen을 이용하여 화면을 정 가운데에 띄워보았다
- width, height, left, top을 각각 2로 나누어 중앙으로 보내기
```
         var child = open('열 URL', '', 'width=200, height=200');
         var childWidth = screen.width / 2;     
         var childHeight = screen.height / 2;
         var childLeft = childWidth / 2;   
         var childTop = childHeight / 2;
         child.resizeTo(childWidth, childHeight);
         child.moveTo(childLeft, childTop);
```         

## location
- 브라우저의 주소 표시줄과 관련된 객체
`location.href = URL` : 지정한 URL로 이동

## history
- history를 만들어 앞, 뒤로 이동할 수 있다
`history.go()` : ()안의 지정한 history로 이동 (-1 : 뒤로가기, +1 : 앞으로 가기)
