import "./App.css";
import {useState} from 'react';

function Header(props) {
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(); // 함수 호출
          }}
        >
          {props.title}
        </a>
      </h1>
      {props.body}
    </header>
  );
}

function Nav(props) {
  const lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(
      <li key={t.id}>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(Number(event.target.id));  // id 가 문자로 넘어오니 숫자로 형변환
          }}
        >
          {t.title}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ul>{lis}</ul>
    </nav>
  );
}

function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}

function App() {
  const [mode, setMode] = useState('WELCOME');
  let [id, setId] = useState(null);
  let topics = [
    { id: 1, title: `HTML`, body: `HTML is for ....` },
    { id: 2, title: `CSS`, body: `CSS is for ....` },
    { id: 3, title: `JavaScrips`, body: `JavaScrips is for ....` },
  ];
  let content = null;

  if (mode === "WELCOME") {
    content = <Article title="Welcome" body="Hello WEB."></Article>;
  } else if (mode === "READ") {
    for(let i=0 ; i<topics.length ; i++){
      var title, body = null;
      if(topics[i].id === id){
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;
  }

  return (
    <div className="App">
      <Header
        title="WEB"
        body="World wide web"
        onChangeMode={() => {
          setMode('WELCOME');
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(_id) => {
          setMode('READ');
          setId(_id);
        }}
      ></Nav>
      <ul>
        <li><button onClick={event =>{

        }}>CREATE</button></li>
        <li><button>UPDATE</button></li>
        <li><button>DELETE</button></li>
      </ul>
      {content}
    </div>
  );
}

export default App;
