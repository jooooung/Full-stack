# SpringBoot

## ✅환경설정
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

## ✅Maven 프로젝트로 jsp 사용하기
- dependency :spring web /  JDBC api /  Oracle Driver / Mybatis framework   / Lombok / Spring Boot DevTools
	- H2 Database : oracle SQL, mySQL 둘 다 사용가능한 데이터베이스

### pom.xml에 dependency 추가
```
	<!-- JSP 파일 사용하기 위한 -->
	<dependency>
		<groupId>javax.servlet</groupId>
		<artifactId>jstl</artifactId>
	</dependency>
	<!-- 톰캣 -->
	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
	</dependency>
```
### application.properties 설정
```
server.port=8090

spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XE
spring.datasource.username=scott
spring.datasource.password=tiger
```

### static폴더에 index.hmtl 생성

### application.properties에 vo, xml 경로 지정
- vo 패키지 : `mybatis.type-aliases-package=com.lec.emp.model`
- xml : `mybatis.mapper-locations=classpath:mappers/**/*.xml`

### repository(dao) 생성
- `@Mapper`

### service  생성
- interface 생성
- interface를 `implements` 받는 class 생성 (`@Service`)
### controller 생성
- `@Controller`
- `@Slf4j` : log를 생성해주는 어노테이션

230512
## ✅인텔리J를 이용한 Gradle 프로젝트
### 1. spring initializr 를 이용한 Gradle 프로젝트 생성
```
Project : Gradle – Groovy
Language : Java
SpringBoot ; 2.7.11
Packaging : Jar
Java : 8
Dependencies : 
spring web /  Thymeleaf / Lombok / Spring Boot DevTools 
```

### 2. 인텔리J 실행
-	프로젝트 열기 : build.gradle로 open as Project
- settings > Build,Execution,Deployment > BuildTools > Gradle > Build and run using과 Run Tests using을 IntelliJ로 바꾸면 속도가 조금 빨라짐

## 배포하기
1. gradlew build
2. 
```
cd build
cd libs
java -jar hello-spring-0.0.1-tab
```

## test 하기
- test class 만들기
	- class명 선택 후 Ctrl+Shift+T
	