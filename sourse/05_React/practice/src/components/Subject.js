import React, { Component } from "react";

class Subject extends Component {
  render() {
    console.log("Subject render");
    return (
      <header className="subject_h">
        <h1>
          <a
            href="/"
            onClick={function (event) {
              event.preventDefault();
              this.props.onChangePage();
            }.bind(this)}
          >
            {this.props.title}
          </a>
        </h1>
        {this.props.sub}
      </header>
    );
  }
}

export default Subject;
