# ✨이벤트
이벤트 : 키보드를 이용해 버튼을 입력하거나 마우스 클릭과 같이 다른 것에 영향을 미치는 것  
`onclick, onmouseover, onmouseout, onkeyup` 등이 있다  
이벤트 걸 시 `window.onload` 필수
## ✔ 01 inline 이벤트 모델
body의 태그 안에 이벤트를 건 후 JS에서 이벤트 생성

## ✔ 02 기본 이벤트 모델(고전적 이벤트 모델)
: 이벤트 속성에 함수 할당(이벤트를 건다)
- on으로 시작하는 속성 : 이벤트속성 ex)onclick
- 이벤트 이름 : click
- 이벤트 속성 변수 : onclick

## ✔ 03 표준 이벤트 모델
`addEventListener('이벤트명', 콜백함수);`

## ✔ 04 this
- 이벤트가 발생된 컴포넌트 객체.  
- this 사용시 화살표 함수 사용 불가

## ✔ 05 이벤트 강제 발생
a함수 안에 b함수를 넣어 a함수 이벤트 발생 시 b함수 이벤트 강제 발생되도록 한다
```
btnA.onclick = function () {
    countA.innerHTML = Number(countA.innerHTML) + 1;    // 문자이기에 Number로 형변환
    btnB.onclick();  
};
btnB.onclick = function () {
    countB.innerHTML = Number(countB.innerHTML) + 1;    // 문자이기에 Number로 형변환
};
```        

## ✔ 06 이벤트 제거
onclick 이벤트 제거하기 : onclick의 기본값인 null을 제거할 곳에 지정하면 된다

## ✔ 07 이벤트 제한
function에 if문 안에 return false를 하면 (디폴트)이벤트 제한

## ✔ 08 이벤트 전달
div A 안에 div B 가 있고 각각 click 이벤트를 건다면 B 클릭시 B 이벤트 발생 후 A 이벤트 발생

## 좌표 표시
`event.screen(X or Y)` : 모니터의 (X or Y) 값
`event.offset(X or Y)` : 브라우저의 (X or Y) 값

## 키 코드
`event.keyCode` : 입력된 키 코드