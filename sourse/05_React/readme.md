<<<<<<< HEAD
# React

## React 설치하기

- node.js 다운로드
- cmd 관리자권한 실행, `npm install –g create-react-app`  
  : 어디서나 global하게 create-react-app 가능
- 폴더(폴더명 소문자) 만들기 (react는 폴더명에 대문자가 들어가면 안된다)
- 생성된 폴더에서 cmd 실행, `npx create-react-app .`  
  폴더 내에 react설치, .은 현재 폴더를 의미

## 소스코드 수정하기

- `npm (run) start` : local host 연결하여 브라우저 열기
- `src`폴더의 `App.js` 파일을 이용하여 소스 코드를 수정할 수 있다

## component 만들기

- react에서 사용자 정의 태그는 첫글자 대문자로 만들어야 한다  
  : `function component명 () { return 내용}`
- 여러 태그를 하나의 부품으로 만들어 적은 복잡도로 소프트웨어를 만들 수 있다
- 내가 만든 것, 남이 만든 것을 공유 가능 -> 생산성 up

## props

react의 속성. component를 사용하는 외부자를 위한 데이터

- component의 매개변수(parameter)에 props를 넣어준다
  : `function component명 props { return 내용}` - 매개변수가 여러가지라면 ()안에 쓰지만 하나라면 생략 가능
- component 태그에 props명 = 내용  
  `<Header title="WEB" body="World wide web"></Header>`
- component에 `{props.title} {props.body}` 추가

### list를 props로 만들기

- App에 배열변수 만들어서 데이터 넣기
- `component` 태그에 `배열변수명={배열변수명}`
- `component`에 `props` 추가, 배열변수 생성하여 li부분 넣기
- `return` 부분에 만들어놓은 배열변수 넣기 -> `{배열변수명}`
- 배열변수에 for문 이용하여 데이터 넣기

```
for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(
      <li key={t.id}>   // li에 key값 지정
        <a href={"/read/" + t.id}>{t.title}</a>
      </li>
    );
}
```

## event

- `component`태그에 `만든 이벤트명={(매개변수) => {}}` 추가
- `component`에서 이벤트 걸 태그에 걸 이벤트 추가

```
이벤트={event => {
    event.preventDefault();     // 이벤트를 수행해도 reload가 수행되지 않게 한다
    props.onChangeMode();   // 함수 호출
}}
```

## state

component를 만드는 내부자를 위한 데이터

- state를 사용하기 위해 import를 해줘야한다  
  `import {useState} from 'react';`
- mode 설정 - `const [mode, setMode] = useState('mode명');`
- 변수 생성 후 if 문 이용하여 각 변수별 상황 설정하기
- App의 `component` 태그의 `onChangeMode`함수에 mode 세팅하기 `setMode('mode명')`
=======
# React 시작하기
- node.js 다운로드
- React 다운받을 폴더 만들기(대문자 X) 
- 폴더 cmd에서 React 다운로드 : `create-react-app .` .은 현재 폴더를 의미
- React 개발환경 실행 : cmd에서 `npx (run) start`   App.js 파일이 브라우저에서 열린다
>>>>>>> 0381c7f7c84b95fbe32bb3f02c76f4e8e26e14d6
