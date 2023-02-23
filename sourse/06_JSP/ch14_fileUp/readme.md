# ✨fileUp : 파일 업로드

## 파일 첨부
- 파일 전달 시에 form 태그 : `method="post" enctype="multipart/form-data"`
    - `enctype="multipart/form-data` : 모든 문자를 인코딩 하지 않을 때, 주로 form태그에서 파일 전송시 사용
    - 메소드 post : 위에서 사용한 enctype 은 post방식만 전송 가능

## 첨부 받은 파일 프로세스(<%%>)
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

## 소스가 바뀌면 저장 파일 없어지는 현상 해결
- 서버에 있는 파일을 프로젝트의 파일 폴더로 복사하기
    - `InputStream`, `OutputStream` 변수 초기화
    - try절 안에서 서버파일 변수 선언
    - 서버파일이 존재한다면 서버에 업로드 될 파일  `InputStream` 사용하여 생성
    - `OutputStream` 이용 프로젝트 폴더에 파일 저장할 폴더/파일명 지정
    - byte[] bs = new byte[(int)serverFile.length()];

## cos.jar 라이브러리로 파일 저장시 역순 저장 해결

- 출력시 역순으로 출력
