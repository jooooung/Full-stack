# ✨fileUp : 파일 업로드

- 파일명 중복 처리하기 : spring은 본인이 처리, JSP에서는 처리 작업이 있음

## 파일 첨부

- 파일 전달 시에 form 태그 : `method="post" enctype="multipart/form-data"`

## 첨부 받은 파일 프로세스

- 첨부할 파일이 저장될 서버 폴더 만들기 : WebContent 밑에 저징될 서버 폴더 생성
- `String path = request.getRealPath("fileUpFolder")` : 첨부할 파일이 저장될 서버 폴더
- 업로드 최대 용량 설정 : `int maxSize = 1024*1024*10` = (10MB)
- `MultipartRequest` :

## 소스가 바뀌면 저장 파일 없어지는 현상 해결

- 서버에 있는 파일을 프로젝트의 파일 폴더로 복사

## cos.jar 라이브러리로 파일 저장시 역순 저장 해결

- 출력시 역순으로 출력
