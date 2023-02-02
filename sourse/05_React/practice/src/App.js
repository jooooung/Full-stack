import "./App.css";
import React, { Component } from "react";
import Subject from "./components/Subject";
import TOC from "./components/TOC";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      mode: "welcome",
      subject: { title: "WEB", sub: "World wide web" },
      contents: [
        { id: 1, title: "HTML", desc: "HTML is HyperText Markup Language." },
        { id: 2, title: "CSS", desc: "CSS is for design" },
        { id: 3, title: "JavaScript", desc: "JavaScript is for interactive" },
      ],
      welcome: { title: "WELCOME", desc: "Hello, React" },
    };
  } // constructor

  render() {
    return (
      <div className="App">
        <Subject
          title={this.state.subject.title}
          sub={this.state.subject.sub}
        ></Subject>
        <TOC date={this.state.contents}></TOC>
        
      </div>
    );
  }
}

export default App;
