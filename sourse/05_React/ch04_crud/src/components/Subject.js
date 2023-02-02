import React, { Component } from "react";
import "./Subject.css";

class Subject extends Component {
  render() {
    console.log('Subject render');
    // this.props.title = 'React'; 내부에서 props 값 변경 불가능 (readonly)
    return (
      <header className="subject_h">
        <h1>
          <a href="/" onClick={function(event){
            event.preventDefault();
            this.props.onChangePage();    // 만든 function 호출
          }.bind(this)}>  {/* this를 쓰기 위해 bind */}
            {this.props.title}
            </a>
        </h1>
        {this.props.sub}
      </header>
    );
  }
}

export default Subject; // 외부에서 access 가능하게
