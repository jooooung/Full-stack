import Subject from "./components/Subject";
import TOC from "./components/TOC";
import Control from "./components/Control";
import ReadContent from "./components/ReadContent";
import CreateContent from "./components/CreateContent";
import UpdateContent from "./components/UpdateContent ";
import React, {useState} from 'react';

function App() {
  const [mode, setMode] = useState('read');   // mode값이 바뀔때마다 rendering
  let [nextId, setNextId] = useState(4); // 현재 contents(삭제되었을 수도 있는)의 가장 큰 id,  create시 사용 
  let [selectedId, setSelectedId] = useState(2);
  let [contents, setContents] = useState ([
    {id: 1, title:'HTML', body:'HTML is HyperText Markup Language'},
    {id: 2, title:'CSS', body:'CSS is for design'},
    {id: 3, title:'JavaScript', body:'JavaScript is for interactive'}
  ]);
  let subject = {title : 'WEB', sub : 'World wide web'};
  let welcome = {title: 'WELCOME', body: 'Hello React'};  
  let _title, _body, _article = null;

  if(mode === 'welcome'){
    _title = welcome.title;
    _body = welcome.body;
    _article = <ReadContent title={_title} body={_body}></ReadContent>
  } else if (mode === 'read'){
    for(var i=0 ; i<contents.length ; i++){
      if(contents[i].id === selectedId){
        _title = contents[i].title;
        _body = contents[i].body;
        break
      }
    }
    _article = <ReadContent title={_title} body={_body}></ReadContent>
  } else if (mode === 'create') {
    _article = <CreateContent onCreate={(_title, _body)=>{
      // alert(_title + ' / ' + _body);     넘어오는지 확인용
      // maxId++ ; {id:4, title: _title, body: _body}객체를 contents에 추가
      let _contents = Array.from(contents);
      _contents.push({id: nextId, title: _title, body:_body});
      setContents(_contents);
      setSelectedId(nextId);
      setNextId(nextId + 1);
    }}></CreateContent>
  } else if (mode === 'update') {
    let _content;
    for (var idx = 0; idx < contents.length; idx++) {
      if(contents[idx].id === selectedId) {
        _content = contents[idx];
        break;
      }
    }
    _article = <UpdateContent data={_content} onUpdate={(_title, _body) => {
      // alert(_title + ' / ' + _body);  수정 되는지 확인용
      // contents를 복제한 _contents의 id가 selectedId와 같은 contents안의 객체를 변경
      // read모드로 전환
      let _contents = [...contents];  // 복제
      for(var idx=0 ; idx<contents.length ; idx++){
        if(_contents[idx].id === selectedId){
          _contents[idx] = {id: selectedId, title: _title, body: _body};
          break;
        }
      } // for - _contents 변경완료
      setContents(_contents);
      setMode('read');
    }}></UpdateContent>
  }

  return (
    <>
      <Subject 
        title={subject.title} sub={subject.sub}
        onChangeMode = {() => {
          // mode = 'welcome';
          setMode('welcome');
        }}
        ></Subject>
      <TOC data={contents} onChangeMode={(_id) => {
        setSelectedId(_id);
        setMode('read');
      }}></TOC>
      <Control onChangeMode={(_mode) => {
        if(_mode === 'delete'){
          if(window.confirm('삭제하시겠습니까?')){
            let _contents = [...contents];
            for(let idx=0 ; idx<contents.length ; idx++){
              if(_contents[idx].id === selectedId){
                _contents.splice(idx, 1);   // idx번째 1개 제거
                let _id;
                if(_contents.length>0){
                  _id = _contents[0].id;    // 제일 작은 id값을 selectedId로
                }else{
                  _id = 0;
                } // if
                setContents(_contents);
                setMode('read');
                setSelectedId(_id);
                break;
              } // if
            } // for
          } // if-confirm
        }else{
          setMode(_mode);
        }
      }}></Control>
      {_article}
    </>
  );
}

export default App;
