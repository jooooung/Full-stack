23.05.09
# 프로젝트 배포하기
- pom.xml에 ojdbc6 추가
- 프로젝트 우클릭 -> export -> war 파일생성

- 사용자 pc에 톰캣 다운로드 -> webapps 폴더에 war 파일 추가
- conf-server.xml에 포트번호 변경
- 톰캣-bin 폴더에서 cmd 실행
	- startup
	- shutdown
	
# node.js (JavaScript 웹프레임워크)
## 다운로드 확인하기 
- cmd에서 node -v (노드 버전 확인)
- node.js download & setup
- IDE = vscode 

## Node.js 환경 setting up
- `npm init` : 어떤 라이브러리를 설치했는지 알 수 있게 하기 위함
- `npm install express` : express 라이브러리 설치
- `node 파일명` : 파일을 node로 실행     
	- 종료 : `ctrl+c`
	- node로 실행 시 수정사항이 있다면 서버를 종료 후 재시작해야한다.
	- 따라서 실시간으로 수정이 되는 `nodemon`을 사용
- `npm install -g nodemon` : `nodemon` 설치. 소스 수정 시 자동으로 서버 시작
- `nodemon 파일명` : nodemon으로 index.js 실행
- 

# MongoDB Atlas 사용하기
- mongoDB는 `table` -> `collections`라 한다.
- 3차원 데이터 구조를 가진다.
## (1) MongoDB 회원가입
- Mongodb atlas 회원가입 후 클러스터 생성(512MB 무료 호스팅받음)
## (2) mongodb 설치
- npm install mongodb@3.6 후 소스 아래와 같이 변경 후 실행(nodemon index.js)

-----------
23.05.10
## 파라미터로 들어온 데이터 DB에 저장하기
- mongoDB에서 collections 만들기
## Cluster0에 Collections 탭에 [Add My Own Data] 
	- database name 지정(user)
	- collection name 지정(table)
## `Insert Document` : 데이터 삽입

## MongoDB 연결
- const MongoClient = require('mongodb').MongoClient;
```
MongoClient.connect(uri, (err, client) => {
  // MongoDB 연결 후 할 일
  // 에러 날 시 콘솔창에 에러 메세지 출력
  if(err){
    return console.log(err);
  }
  db = client.db('ToDoApp'); // 'ToDoApp' 데이터베이스 연결
  app.listen(8090, () => {
    console.log('listening on 8090');
  });
});
```

## ejs 라이브러리 설치
- npm install ejs
- view 엔진으로 ejs 등록 : `app.set('view enging', "ejs"); `

23.05.11
## detail

## update
- ajax를 이용한 put 방식 전달