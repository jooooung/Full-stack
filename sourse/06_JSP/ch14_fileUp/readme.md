# ✨fileUp : 파일 업로드

## ✔파일 첨부
- 파일 전달 시에 form 태그 : `method="post" enctype="multipart/form-data"`
    - `enctype="multipart/form-data` : 모든 문자를 인코딩 하지 않을 때, 주로 form태그에서 파일 전송시 사용
    - 메소드 post : 위에서 사용한 enctype 은 post방식만 전송 가능

## ✔첨부 받은 파일 프로세스
- 첨부할 파일이 저장될 서버 폴더 만들기 : WebContent 밑에 저징될 서버 폴더 생성
    - 서버 wtpwebapps - 프로젝트 폴더에도 동기화 된다
- `String path = request.getRealPath("파일 저장 폴더")` : 첨부할 파일이 저장될 서버 폴더
- 업로드 최대 용량 설정 : `int maxSize = 1024 * 1024 * 10` = (10MB)
- 서버에 저장될 파일명, 원본 파일명 변수 선언
- `MultipartRequest` 선언 : JSP에서는 try-catch를 안해도 되지만 JAVA에서는 사용해야 되므로 해주는게 좋다
    - MultipartRequest 에 위임시 request 불가
    - 매개변수 `new DefaultFileRenamePolicy()` : 같은 이름의 파일이 있을 경우 파일명 자동 변경
- `Enumeration<String> paramNames = paramNames.getFileNames();` : 파일 첨부한 파라미터들
- while문으로 paramNames 출력
    - `paramNames.nextElement()` 변수 지정
    - 파라미터로 올라온 파일 이름, 파라미터에 첨부한 원본 파일이름 변수 지정

## ✔소스가 바뀌면 저장 파일 없어지는 현상 해결
- 서버에 있는 파일을 프로젝트의 파일 폴더로 복사하기
    - `InputStream`, `OutputStream` 변수 초기화
    - try절 안에서 서버파일 변수 선언
    - 서버파일이 존재한다면 서버에 업로드 될 파일  `InputStream` 사용하여 생성
    - `OutputStream` 이용 프로젝트 폴더에 파일 저장할 폴더/파일명 지정
    - byte[] bs = new byte[(int)serverFile.length()]; : 복사한 서버 파일의 길이만큼 배열 생성

## ✔cos.jar 라이브러리로 파일 저장시 역순 저장 해결

- 출력시 역순으로 출력

# ✨도서사이트(lect2_book)
## 도서 등록
- 메인 표지, 상세 이미지 등록
- 가격, 할인율 입력 시 할인된 가격 표시
- 책 소개 글

## 도서 목록
- 메인 표지, 도서 번호, 도서명, 원가격, 할인가격, 할인율 표시
- 표지, 도서명 클릭 시 상세보기 페이지로 이동

## 도서 상세보기
- 메인표지, 도서 번호, 도서명, 원가격, 할인가격, 할인율
- 구매하기(미동작), 책목록 버튼
- 상세내용

## 코드순서
### 1. DB 테이블 생성
- 도서번호는 `SEQUENCE` 이용
- `QUERY` 생성
    1. 책등록 (더미데이터 삽입 시 항상 마지막에 commit하기)
    2. 책리스트(paging (top-n구문 이용))
    3. 등록된 책 개수
    4. 상세보기(도서번호로 정보 가져오기)

### 2. DTO, DAO
#### DTO
- 데이터 `private` 변수로 선언
- 매개변수 없는 생성자, 있는 생성자 생성
- `getter&setter` 생성
- 오류날 시 사용하기 위해 `toString()` 도 만들어주면 좋다
- 위에서 만든 것들 중에 사용 안 하는것도 있지만 혹시 모르니 미리 만들어주었다

#### DAO
- 성공, 실패 final 변수 선언
- 싱글톤 객체 생성
- 커넥션 풀에서 conn 객체 가져와 반환
- `QUERY` 메소드 생성

### 3-1. 책등록
- form태그
    - `action` : 프로세스 처리할 파일명
    - `method` : post -> 파일 첨부시 enctype 사용하기 때문
    - `enctype="multipart/form-data"` : 파일이나 이미지 전송시 사용
### 3-2. 책등록 프로세스
- `String 변수 : request.getRealPath("폴더명");` : 서버 파일이 저장될 폴더의 경로 변수 지정
- 업로드 사이즈 설정
- 메인 표지, 상세 표지 첨부파일이 한 개 이상이므로 배열 변수 선언
- 