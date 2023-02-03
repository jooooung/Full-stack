const TOC = (props) => {
  let lists = [];
  let data = props.data;
  for (let idx = 0; idx < data.length; idx++) {
    lists.push(
      <li key={data[idx].id}>
        <a
          href={data[idx].id + ".html"}
          id={data[idx].id}
          onClick={(event) => {
            event.preventDefault(); // 현 페이지에 머물기
            // console.log(event.target);
            // debugger;
            props.onChangeMode(Number(event.target.id));
          }}
        >
          {data[idx].title}
        </a>
      </li>
    );
  } // for

  return (
    <nav>
      <ul>{lists}</ul>
    </nav>
  );
};

export default TOC;
