# ✨문서객체모델
## ✔문서객체 생성
### 방법 1 (text 추가)
1. h1태그생성 `document.createElement('h1');`
2. textNode생성 `document.createTextNode('textNode');`
3. textNode를 h1태그에 연결 `h1.appendChild(textNode);`
4. h1태그를 body에 추가 (window.onload를 먼저 해야 추가가 된다) `document.body.appendChild(h1);`

### 방법 2 (img 추가해보기)
1. img 태그생성  `var img = document.createElement('img');` 
2. src 속성변경  `img.setAttribute('src', 'img/red.jpg');`
3. body에 img 태그 추가 `document.body.appendChild(img);`

### 방법 3 innnerHTML 이용 
`document.body.innerHTML += '내용`;

## ✔문서객체가져오기
### 방법 1 : id 이용
가져올 객체에 id 지정 후 `document.getElementById(id명);`

### 방법 2 : class 이용
`document.getElementsByClassName(class명)` : 배열 return

### 방법 3 : name 이용
`document.getElementsByName(name명)` : 배열 return  

### 방법 4 : tagName 이용
`document.getElementsByTagName(tag명)` : 배열 return

### 방법 5 : querySelector(선택자) : 선택자 1(배열의 첫 1개)

### 방법 6 : querySelectorAll(선택자) : 선택자 전부(배열)

## ✔ 문서객체제거
함수안에 `document.body.removeChild(선택자)`  로 제거할 수도 있다

## ✔ 새 창 열기, 두 창 간 데이터 통신
1. parent 창에서 할 일 : child 창 open
    - button 만들어 onclick 이벤트 걸기  `<button onclick="confirmOpen()">중복확인</button>`
    - onclick에 걸어놓은 함수 만들기 (open('열 파일', '지정할 이름', '사이즈지정'))
```
function confirmOpen() {
    var child = open('confirm.html', '', 'width300, height=300, left=100');
    if (!child) {
        alert('팝업 허용해주세요');
    }
}
```        
2. child 창에서 할 일 : opener(parent)의 데이터 받아, 내 document 객체에 뿌리기 (가져올 시 opener의 id만 가능)
    - parent에서 가져올 데이터 가져오기  
    `var 변수명 = opener.document.getElementById('parent에서 가져올 id').value;`
    - 가져온 데이터 child에 추가 `innerHTML` 이용
    - 다시 parent에 데이터 보내고 child 창 닫기  
    `opener.document.getElementById('parent의 id').value = child의 id;`  
    `close()`
    