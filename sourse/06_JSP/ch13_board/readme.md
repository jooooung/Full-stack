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

## ✔ 글쓰기(writeForm.jsp)
- form 태그
    - 작성자(로그인 시에는 닉네임 받기), 제목, 본문, 이메일, 비밀번호
    - 글쓰기(submit), 취소(reset), 목록(button onclick이벤트) 버튼

## ✔ 쓴 글 저장(writePro.jsp)
- dto, dao 가져오기
- `int result = bDao.insertBoard(dto);`	: 글 저장하기

## ✔ 글 상세보기(content.jsp)
- num(글번호), pageNum(페이지번호) 파라미터 받기
- DAO, DTO 선언
- if 문으로 글 번호(dto가 null)가 null이면 글목록 페이지로   
 null이 아니면 조회수 올리기
- 출력시 조회수 + 1로 올라간 조회수 표시

## ✔ 글 수정(updateForm.jsp)
- num(글번호), pageNum(페이지번호) 파라미터 받기
- DAO, DTO 선언
- form 태그
    - action : 수정 데이터 처리할 updatePro.jsp
    - method : 글비밀번호가 있기에 post로 전송
    - num, pageNum hidden 타입으로 전달

## ✔글수정처리(updatePro.jsp)
- post로 받은 데이터 utf-8로 언어 변경
- bean태그로 데이터 받기
- pageNum 파라미터 
- 작성자의 IP 세팅
- DAO 받아서 result변수에 update하기
- 글수정 성공 시 글상세보기(content)로 이동 : 이동시 num, pageNum데이터 같이 이동

## ✔글삭제(deleteForm.jsp)
- num, pageNum 파라미터 받기
- num, pageNum hidden 타입으로 전달
- 글비밀번호 입력받기

## ✔글삭제처리(deletePro.jsp)
- num 파라미터 int로 형변환
- pageNum, pw 파라미터 받기
- Dao 받아 result에 num, pw 매개변수인 deleteBoard 메소드 선언
- 삭제 완료시 pageNum 데이터 포함하여 list로 가기

## @ 프로젝트 복사 시 해야할 것
- 프로젝트 프로퍼티스 -> 웹 프로젝트 세팅의 Context root 프로젝트명으로 바꾸기 : 다른 프로젝트의 Context root와 중복되면 안됨