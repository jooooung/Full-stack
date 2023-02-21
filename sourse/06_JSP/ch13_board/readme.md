# ✨게시판 만들기

##  ✔데이터
- 글번호, 제목, 작성자, 작성일, 본문내용, 조회수, 이메일, 글그룹(REFERENCE), 답변글 들여쓰기, IP

## ✔기능
- 글쓰기
- 답변글 : 원글의 레퍼런스를 저장하고 있어야한다, 답변글끼리의 순서 설정, 들여쓰기 설정
- 글수정
- 글삭제(비밀번호)
- 댓글
- 좋아요
- 일정 조회수 넘으면 제목에 효과주기
- 예외페이지

## ✔TABLE 
- 필요한 데이터 생성 : `PRIMARY KEY`, `NOT NULL`등 필요조건 걸어 만들기
### QUERY  
    - 글개수
    - 글목록(최신글이 위로)
    - 글쓰기(원글) : 글쓰기 시 글번호 생성
    - 글 번호로 글 상세내용 가져오기
    - 조회수 올리기
    - 글수정
    - 글삭제

## ✔DTO, DAO
### DTO
1. private 변수 만들기
2. 생성자 만들기(매개변수x, 매개변수o)
3. getter&setter 생성
4. toString생성 : 없어도 되지만 오류 발생 시 사용하면 유용

### DAO
1. final 변수 `SUCCESS`, `FAIL` 생성 : 결과 여부
2. 싱글톤 생성
3. 커넥션 풀
4. 필요한 기능 메소드 만들기
5. 테스트하기

## ✔errorpage 
1. 프로젝트의 WEB-INF/web.xml 파일에 에러페이지 추가
```
    <error-page>
        <error-code>404</error-code>
        <location>/error/error404.jsp</location>
	</error-page>
```
2. error404.jsp 만들어서 404 에러시 표시할 내용 생성

## ✔ 글목록 페이지(list.jsp)
- 글쓰기 a 태그
- DAO 가져오기
- 글개수 메소드 가져와 글 표시
    - 0 = 글 없음 표시
    - 0 != ArrayList로 Dto 받아 데이터 출력