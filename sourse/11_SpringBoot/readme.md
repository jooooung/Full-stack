# SpringBoot

## 환경설정
### sts 4 압축풀기
- sts4가 있는 폴더에서 cmd 실행  
 java -jar 탭을 누르면 파일명이 자동으로 생성 -> 엔터 -> 압축풀림

### 압축풀린 폴더에 lombok 추가하기 
- lombok 폴더에서 cmd 실행
- lombok 실행 : java -jar lombok.jar
	- location 클릭 후 SpringToolSuite4.exe 선택 -> 인스톨

### SpringToolSuite4.ini 수정
- JAVA 사용 버전에 맞게 수정
- 한글 처리 : `-Dfile.encoding=utf-8`

### Eclipse Marketplace 
- Eclipse Enterprise Java and Web Developer Tools 3.2x 인스톨

### 프로젝트 생성
#### 웹에서 생성
- https://start.spring.io/ 에서 생성
- dependency 추가 : spring web / Lombok / Spring Boot DevTools / thymeleaf

#### sts4에서 생성
- New Spring Starter Project로 생성
- version : 0.0.1-SNAPSHOT  -> 배포용
- dependency 추가 : spring web / Lombok / Spring Boot DevTools / thymeleaf

### 서버 설정, index.html 생성
- `application.properties`에 추가 : `server.port=8090`
- 정적 뷰 : static 폴더에
- 동적 뷰 : template 폴더에

### 실행하기
1. `@SpringBootApplication`(컨트롤러)에서 실행
2. 프로젝트 우클릭 - run as - Spring Boot App

