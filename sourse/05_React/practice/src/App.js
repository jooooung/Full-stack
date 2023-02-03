import TOC from "./components/TOC";
import Subject from "./components/Subject";
import Control from "./components/Control";
import ReadContent from "./components/ReadContent";
import CreateContent from "./components/CreateContent";
import UpdateContent from "./components/UpdateContent";
import React, {useState} from 'react';

function App() {
  const [mode, setMode] = useState('read');;
  let [nextId, setNextId] = useState(4);
  let [selectedId, setSelectedId] = useState(2);
  let [contents, setContents] = useState([
    {id: 1, title:'HTML', body:'HTML is HyperText Markup Language'},
    {id: 2, title:'CSS', body:'CSS is for design'},
    {id: 3, title:'JavaScript', body:'JavaScript is for interactive'}
  ]);
  let subject = {title: 'WEB', sub: 'World wide web'};
  let welcome = {title: 'WELCOME', body: 'Hello React'};
  let _title, _body, _article = null;
  
  if(mode === 'welcome'){
    _title = welcome.title;
    _body = welcome.body;
    _article = <ReadContent title={_title} body={_body}> </ReadContent>
  } else if(mode === 'read'){
    for(var i=0 ; i<contents.length ; i++){
      if(contents[i].id === selectedId){
        _title = contents[i].title;
        _body = contents[i].body;
        break;
      }
    }
    _article = <ReadContent title={_title} body={_body}> </ReadContent>
  } else if(mode === 'create'){
    _article = <CreateContent onCreate={(_title, _body)=>{
      let _contents = [...contents];
      _contents.push({id: nextId, title: _title, body: _body});
      setContents(_contents);
      setSelectedId(nextId);
      setNextId(nextId + 1);
    }}> </CreateContent>
  } else if(mode === 'update'){
    let _content;
    for(var idx=0 ; idx<contents.length ; idx++){
      if(contents[idx].id === selectedId){
        _content = contents[idx];
        break;
      }
    }
    _article = <UpdateContent data={_content} onUpdate={(_title, _body) =>{
      let _contents = [...contents];
      for(var idx=0 ; idx<contents.length ; idx++){
        if(_contents[idx].id === selectedId){
          _contents[idx] = {id: selectedId, title: _title, body: _body};
          break;
        }
      }
      setContents(_contents);
      setMode('read');
    }}> </UpdateContent>
  }


  return (
    <div>
      <Subject title={subject.title} sub={subject.sub}
      onChangeMode = {() => {
        setMode('welcome');
      }}  ></Subject>    
      <TOC data={contents} onChangeMode = {(_id) => {
        setSelectedId(_id);
        setMode('read');
      }}></TOC>
      <Control onChangeMode={(_mode) => {
        if(_mode === 'delete'){
          if(window.confirm('삭제할까요')){
            let _contents = [...contents];
            for(let idx=0 ; idx<contents.length ; idx++){
              if(_contents[idx].id === selectedId){
                _contents.splice(idx, 1);
                let _id;
                if(_contents.length>0){
                  _id = _contents[0].id;
                }else{
                  _id = 0;
                }
                setContents(_contents);
                setMode('read');
                setSelectedId(_id);
                break;
              }
            }
          }
        }else{
          setMode(_mode);
        }
      }}></Control>
      {_article}
    </div>
  );
}

export default App;
