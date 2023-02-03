import "./Subject.css";

const Subject = (props) => {
  // 화살표 함수 사용, functionComponent는 대문자 시작
  // props.title = 수정불가(ReadOnly), 수정 시 state변수화를 시켜야 한다
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
