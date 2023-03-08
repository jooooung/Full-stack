# mvcBoard
## db
1. TABLE & SEQUENCE drop & create
2. query
3. dto, dao
## service package(Model)
### 1. Service (interface) : request, response 객체
### 2. BListService : 글목록 
- paging 후 page 관련 항목들 `request.setAttrubute`
### 3. BWriteService : 글쓰기
- bname, btitle, bcontent 파라미터 받고 bip 가져와서 db에 write
### 4. BContentService : 상세보기
- `paging`
- list.jsp(view)에 paging 관련 request 보내기 
: `currentPage` `pageCnt` `startPage` `endPage` `BLOCKSIZE` 를 request에 추가 

## Controller package
### 1. Bcontroller
- `method`가 `get` 또는 `post`로 올지 모르니 공통 `method` 생성
- 공통 `method` : command(uri - conPath) 변수 생성
- 들어온 url mapping 처리
  - 1. list.do : 글목록 
  - 2. writeView.do : 글쓰기 - 글쓰기시 변수 지정 후 1로 지정
  - 3. write.do : 쓴 글 DB에 저장 - 글쓰기시 지정한 변수 0으로 지정 (글 쓴 후 목록페이지에서 새로고침 시 중복글 방지)
 
## WebContent - board 폴더(View)
1. list.jsp
- 답글 표시, 들여쓰기 
- 제목 링크 : 상세보기.do에 bid, pageNum 넘기기, 조회수 높은 글 효과
- paging 표시 : 이전, 다음 링크 / 현재 페이지 표시
2. write_view.jsp
3. content_view.jsp