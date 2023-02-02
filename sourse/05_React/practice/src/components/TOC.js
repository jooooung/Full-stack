import React, { Component } from "react";

class TOC extends Component {
    shouldComponentUpdate(newProps){
        if(newProps.data === this.props.data){
            return false;
        }
        return true;
    }
  render() {
    console.log('TOC render');
    var lists = [];
    var data = this.props.data;
    for (var i = 0; i < data.length; i++) {
      lists.push(
        <li key={data[i].id}>
        <a href={data[i].id + ".html"}
            data-id={data[i].id}
            onClick={function (event) {
            event.preventDefault();
            // console.log(event.target.dataset.id);
            // debugger;
            this.props.onChangePage(event.target.dataset.id);   // 매개변수가 string -> App.js에서 Number로 형변환했음
          }.bind(this)}>
          {data[i].title}
        </a>
      </li>
      );
    }
    return (
      <nav>
        <ul>{lists}</ul>
      </nav>
    );
  }
}

export default TOC;
