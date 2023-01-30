# 문서객체모델
## 문서객체 생성
### 방법 1
1. h1태그생성 `document.createElement('h1');`
2. textNode생성 `document.createTextNode('textNode');`
3. textNode를 h1태그에 연결 `h1.appendChild(textNode);`
4. h1태그를 body에 추가 (window.onload를 먼저 해야 추가가 된다) `document.body.appendChild(h1);`

### 방법 2
1. img 태그생성  `var img = document.createElement('img');` 
2. src 속성변경  `img.setAttribute('src', 'img/red.jpg');`
3. body에 img 태그 추가 `document.body.appendChild(img);`

### 방법 3 innnerHTML 이용
`document.body.innerHTML += '내용`;

## 문서객체가져오기
### 방법 1 : id 이용
가져올 객체에 id 지정 후 `document.getElementById(id명);`

### 방법 2 : class 이용
`document.getElementsByClassName(class명)` : 배열 return

### 방법 3 : name 이용
`document.getElementsByName(name명)` : 배열 return

### 방법 4 : tagName 이용
`document.getElementsByTagName(tag명)` : 배열 return

### 방법 5 : querySelector(선택자) : 선택자 1(처음 1개) 
### 방법 6 : querySelectorAll(선택자) : 선택자 전부(배열)