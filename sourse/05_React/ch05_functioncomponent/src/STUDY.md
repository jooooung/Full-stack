# function Component

0. App.js 만들기
1. component 만들고 연결
2. Subject
``` 
<Subject title="WEB" sub="World wide web"></Subject>
props 넣어주기 
- Subject.js : 화살표 함수에 객체로 props넣어주고 
return에 {props.title} {props.sub}
객체에 {title, sub} 바로 넣고 return에 {title} {sub} 사용가능

Component에 props가 input 때에는 불변
내부적으로 props를 바꿀 시 state화 시킨다
-> 유사 HTML로 output
```

3. TOC
TOC content 배열 만들기
```
##App에서
let contents = [ ];
<TOC data={contents}></TOC>
##TOC에서
let lists = [ ];
return 안에 contents가져온거 {lists}로 변경
li에 key값 주기
a href에 data-id={data[idx].id} 추가
```

4. ReadContent
```
ReadContent props
##App
<ReadContent title="CSS" body="CSS is for design"></ReadContent>
##ReadContent
<h2>{title}</h2>
{body}
```

5. mode 별 설정
```
변수 만들기 : welcome, _title, _body, _article, subject, mode, maxId, selectedId
if문 mode별 설정

 click이벤트 주기 - 
 App #Subject태그에 onChangeMode 추가 - Subject.js_h1태그에 onClick 추가
 const [mode, setMode] = useState('read');   // mode값이 바뀔때마다 rendering  (import 해주기)
 onChangeMode 화살표 함수 안에 setMode('welcome');로 변경

TOC태그 onChangeMode 화살표함수 매개변수 _id, setMode('read'); 추가
TOC.js - a태그 onClick 추가
```

화면과 관련된 모든 변수는 다 state화 하면 된다 `let [변수이름, set변수이름] = useState 값;`