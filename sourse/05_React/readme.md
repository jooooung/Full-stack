# App.js
- `Component`를 상속받는 class `App` 만들기 - `Component` import하기
- `App` export 하기 : `export default App;`

















Subject 수정 - web 클릭 이벤트 걸기
1. header h1에 a 태그 추가
2. App.js- this.state에 mode: 'read' 추가
3. Content.js -> ReadContent로 이름 변경 - class명, import, App.js의 태그 변경 

4. App.js 의 render- return 전에 if(mode)문 추가
```
var _title, _desc = null;
    if(this.state.mode === 'welcome'){      // 'welcome'일 때 조건 걸기
      _title = this.state.welcome.title;    
      _desc = this.state.welcome.desc;
    }else if(this.state.mode === 'read'){       // 'read'일 때 조건 걸기
      _title = this.state.contents[0].title;
      _desc = this.state.contents[0].desc;
    }

// title과 decs 를 _title, _desc로 가져오게 변경
<ReadContent
    title={_title}
    desc={_desc}
></ReadContent>
```

5. a 태그에 클릭 이벤트 주기
```
<a href="/" onClick={function(event){
              event.preventDefault();   // a 태그의 기본 event 기능을 막음
              // this.state.mode = 'welcome';  // state값은 바로 변경해도 화면에 반영 안 함
              this.setState({
                mode : 'welcome'
              });    // .bind(this) = this를 윈도우가 아닌 현재 객체로
            }.bind(this)}>    
```             

rendering : 화면이 바뀌는 것  
setState를 이용하면 모든 태그가 rendering되어 불필요한 동작 수행 ->  `shouldComponentUpdate` 이용

- TOC에 이벤트 걸기
App.js - `this.state`에 `selected_content_id` 변수 추가(contents id를 위한 변수)
`onChangePage` function 추가 - setState - mode 설정- id 가져오기
```
        <TOC data={this.state.contents}
        onChangePage={function(id){   // contents가 배열이므로 어떤 id를 선택할지 매개변수에 넣었다
          this.setState({
            mode: 'read',
            selected_content_id: Number(id),
          });
        }.bind(this)}></TOC>
```        



- react 앱 만들시 폴더에 대문자가 들어가면 안된다
