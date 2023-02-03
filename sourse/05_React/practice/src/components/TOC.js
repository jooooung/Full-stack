const TOC = (props) => {
  let lists = [];
  let data = props.data;
  for (let idx = 0; idx < data.length; idx++) {
    lists.push(
      <li>
        <a
          href={data[idx].id + ".html"}
          id={data[idx].id}
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(Number(event.target.id));
          }}
        >
          {data[idx].title}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ul>{lists}</ul>
    </nav>
  );
};

export default TOC;
