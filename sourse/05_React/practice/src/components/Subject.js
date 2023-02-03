const Subject = props => {
  return (
    <header className="Subject">
      <h1 onClick={event => {
        props.onChangeMode();
      }}>
        {props.title}
        </h1>
      {props.sub}
    </header>
  );
};

export default Subject;
