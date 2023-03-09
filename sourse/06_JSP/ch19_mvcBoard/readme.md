# ✨mvcBoard
## ✅db
1. TABLE & SEQUENCE drop & create
2. query
3. dto, dao
---
---
## ✅Model - service package
### 1. Service (interface) : request, response 객체
### 2. BListService : 글목록 
- paging 후 page 관련 항목들 `request.setAttrubute`
### 3. BWriteService : 글쓰기
- bname, btitle, bcontent 파라미터 받고 bip 가져와서 db에 write
### 4. BContentService : 상세보기
- `paging`
- list.jsp(view)에 paging 관련 request 보내기 
: `currentPage` `pageCnt` `startPage` `endPage` `BLOCKSIZE` 를 request에 추가 
#### 5. BModifyViewService : 글수정
- bid 파라미터 받아 보내기

#### 6. BmodifyService : 수정 글 저장
- bname, btitle, bcontent, 파라미터 받아 보내기
- bip 세팅 후 request

#### 7. BDeleteService : 글삭제
- result 변수에 dao의 delete 메소드 선언
- deleteResult 변수 : 삼항연산자 이용 성공/실패 메세지 출력

#### 8. BReplyViewService
- 원글의 bid request 받기
- dao 가져와 원글의 dto `setAttribute`

#### 9. BReplyService
---
---

## ✅Controller package
### 1. Bcontroller
- `method`가 `get` 또는 `post`로 올지 모르니 공통 `method` 생성
- 공통 `method` : command(uri - conPath) 변수 생성
- `viewPage`, `service` 변수 선언
- 들어온 url mapping 처리
  - 1. list.do : 글목록 
  - 2. writeView.do : 글쓰기 - 글쓰기시 변수 지정 후 1로 지정
  - 3. write.do : 쓴 글 DB에 저장 - 글쓰기시 지정한 변수 0으로 지정 (글 쓴 후 목록페이지에서 새로고침 시 중복글 방지)
  - 4. contentView.do : 상세보기
  - 5. modifyView.do : 글수정
  - 6. modify.do : 수정 글 저장 : 저장 후 상세보기로 갈 시 상세보기view에서 `alert` 출력
  - 7. delete.do : 글 삭제
  - 8. replyView.do : 답글 : 원글의 bgroup, bstep, bindent 필요
  - 9. reply.do : 답글 DB에 저장

 ---
 ---

## ✅View : WebContent - board 폴더
1. list.jsp : 목록
- 글쓰기, 수정, 삭제 성공여부
- 답글 표시, 들여쓰기 
- 제목 링크 : 상세보기.do에 bid, pageNum 넘기기, 조회수 높은 글 효과
- paging 표시 : 이전, 다음 링크 / 현재 페이지 표시
2. write_view.jsp : 글쓰기
3. content_view.jsp : 상세보기
4. modify_view.jsp : 글수정
- `hidden` 타입으로 `bid`, `pageNum` 보내기 : 수정글 번호, 수정글 페이지 
5. reply_view.jsp : 답글
- `pageNum`, `bgroup`, `bstep`, `bindent` : hidden 타입으로 보내기