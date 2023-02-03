import React, { useState } from "react";

const UpdateContent = (props) => {
  const [title, setTitle] = useState(props.data.title);
  const [body, setBody] = useState(props.data.body);
  return (
    <article>
      <h2>UPDATE</h2>
      <form
        action="/update_process"
        method="get"
        onSubmit={(event) => {
          event.preventDefault();
          //   console.log(event.target.title.value);
          //   debugger;
          props.onUpdate(title, body);
        }}
      >
        <p>
          <input
            type="text"
            name="title"
            placeholder="title"
            value={title}
            onChange={(event) => {
              // event.target.value를 title(state화)
              setTitle(event.target.value);
            }}
          ></input>
        </p>
        <p>
          <textarea
            name="body"
            placeholder="body"
            value={body}
            onChange={(event) => {
              setBody(event.target.value);
            }}
          ></textarea>
        </p>
        <p>
          <input type="submit" value="수정"></input>
        </p>
      </form>
    </article>
  );
};

export default UpdateContent;
