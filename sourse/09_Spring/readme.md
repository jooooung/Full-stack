# ✅Spring

## 여러사람이 협업하기 좋게 가독성이 높게 JSP의 틀을 만들어 놓은 것

---
[✨1. Spring 세팅하기](#✨1-spring-세팅하기)  
[✨2. spring 개요](#✨2-spring-개요)  
[✨3. DI(Dependency Injection) 개념 및 활용 (의존성 주입)](#✨3-didependency-injection-개념-및-활용-의존성-주입)
## ✨1. Spring 세팅하기

### ①. STS 다운로드

1. 스프링 홈페이지 - 프로젝트 -> 스프링 툴스 4 하단의 Spring Tool Suite 3의 Spring Tool Suite 3 wiki 클릭(Spring Tool Suite 3.9.13까지 JDK8을 지원한다)

2. 다운로드 후 IDE에 압축풀기

3. Lombok 다운로드(DTO 자동생성 라이브러리)

   - lombok 실행 후 sts 추가 인스톨  
     (실행 안 될 시 cmd창에서 java -jar lombok.jar 로 추가 실행) - sts-3.9.13.RELEASE폴더의 STS.ini 에 `win32-x86_64\sts-bundle\sts-3.9.13.RELEASE\lombok.jar` 추가 되었는지 확인
   - utf-8로 세팅 : STS.ini에 `-Dfile.encoding=utf-8` 추가

4. STS.exe 실행 에러 시
   - STS.ini 파일에 추가
   - sts.exe 바로가기에 `-clean` 추가

## ② 서버 설정

- 기존 서버 폴더 삭제 후 톰캣 폴더 복사하여 IDE에 이동
- 복사 시 lib에 `jstl.jar`, `standard.jar` 여부 확인

<br>
<br>

## ✨2. Spring 개요

### ③ 프로젝트 만들기

1. Spring legacy project - Simple Spring Utility Priject- next 후 다운로드 - Package 이름 지정

- C:\Users\dhdtn\\.m2라는 폴더가 생성된다
- 프로젝트에 오류 시 우클릭 - Maven - Update

## ④ `dependencies`에 Lombok 추가하기

- pom.xml : `dependencies` = 사용 라이브러리 종류가 담아져있다
- https://mvnrepository.com - Lombok 검색 후 다운받은 버전 클릭 - 코드 복사하여 추가

## ⑤ Lombok 사용하기

- `@Data` : getter, setter, toString 자동 생성
- `@NoArgsConstructor` : 매개변수 없는 생성자 생성
- `@AllArgsConstructor` : 매개변수 있는 생성자 생성

## ⑥ bean

- resources폴더에 Spring bean 파일 만들기
- 유지보수 시에 class 파일을 수정하지 않고 bean. 즉 xml 파일만을 수정하여  
  유지보수 할 수 있는 장점이 있다

---

<br>
<br>

# ✨3. DI(Dependency Injection) 개념 및 활용 (의존성 주입)

- 의존하는 클래스를 외부의 컨테이너 생성 후 객체 만들어서 필요할 때 가져다 쓰는 것
