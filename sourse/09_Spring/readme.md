# ✅Spring

## 여러사람이 협업하기 좋게 가독성이 높게 JSP의 틀을 만들어 놓은 것

---

[✨ Spring 세팅하기](#✨-spring-세팅하기)  
[✨1. spring 개요](#✨1-spring-개요)  
[✨2. DI(Dependency Injection) 개념 및 활용 (의존성 주입)](#✨2-didependency-injection-개념-및-활용-의존성-주입)  
[✨3. DI(Dependency Injection) 설정방법](#✨3-didependency-injection-설정방법)  
[✨4. DI(Dependency Injection) 자동의존 설정과 빈 생명주기와 범위](#✨4-didependency-injection-자동의존-설정과-빈-생명주기와-범위)  
[✨5. 외부파일propertiesfile을 이용한 설정](#✨5-외부파일propertiesfile을-이용한-설정)  
[✨6. AOP(aopaspect oriented. programming)](#✨6-aopaspect-oriented-programming)  
[✨7. MVC](#✨7-mvc)  
[✨8. controller](#✨8-controller)
># ✨ Spring 세팅하기
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
- 복사 시 lib 폴더에 `jstl.jar`, `standard.jar` 여부 확인

<br>
<br>

>## ✨1. Spring 개요

### ✔프로젝트 만들기

- Spring legacy project - Simple Spring Utility Priject(web이 아닌 프로젝트)
- next 후 다운로드 - Package 이름 지정

- C:\Users\사용자이름\\.m2라는 폴더가 생성된다
- 프로젝트에 오류 시 우클릭 - Maven - Update

## ✔`dependencies`에 Lombok 추가하기

> <b>`dependency`란 객체 간의 관계를 의미</b>

- pom.xml : `dependencies` = 사용 라이브러리 종류가 담아져있다
- https://mvnrepository.com - Lombok 검색 후 다운받은 버전 클릭 - 코드 복사하여 추가

```
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
	<dependency>
	    <groupId>org.projectlombok</groupId>
	    <artifactId>lombok</artifactId>
	    <version>1.18.26</version>
	    <scope>provided</scope>
</dependency>
```

## ✔Lombok 사용하기

> 그동안 `class`에서 직접 생성자나 getter를 만들어줬지만  
>  Lombok을 사용하면 아주 편리하게 사용 할 수 있다.

- `@Data` : getter, setter, toString 자동 생성
- `@NoArgsConstructor` : 매개변수 없는 생성자 생성
- `@AllArgsConstructor` : 매개변수 있는 생성자 생성

## bean

- resources폴더에 Spring bean 파일 만들기`(Spring Bean Configuration File)`
- 유지보수 시에 class 파일을 수정하지 않고 bean. 즉 xml 파일만을 수정하여  
  유지보수 할 수 있는 장점이 있다

---

<br>
<br>

># ✨2. DI(Dependency Injection) 개념 및 활용 (의존성 주입)

## 1. 스프링을 이용한 객체 생성과 조립

- 의존하는 클래스를 외부의 컨테이너 생성 후 객체를 만들어서 필요할 때 가져다 쓰는 것

># ✨3. DI(Dependency Injection) 설정방법

## ✔1. XML 파일을 이용한 DI 설정방법

- 객체 세팅 : `property`
  - `<property name="student" value="student"/>` : `value는 기초데이터 타입, String
  - `<property name="student" ref="student"/>` : `ref` 는 다른 빈 객체 설정
- p를 이용한 객체 세팅: bean 태그에서 바로 세팅
  - ` <bean id="id" class="경로" p:객체이름="객체값">`
- 값 세팅 = `<constructor-arg value="홍길동"/>`
- 여러값 세팅 : 순서대로 지정

```
<constructor-arg>
    <list>
        <value>값</value>
        <value>값</value>
    </list>
</constructor-arg>
```

## ✔2. Java(어노테이션)를 이용한 DI 설정방법(잘 쓰이지는 않는다)

- java 파일에서 xml역할을 사용하기
- pom.xml에 의존추가

```
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>2.2.2</version>
</dependency>
```

- `@Configuration` : xml역할을 할 java 파일에서 파싱하기 위해 쓴다

## ✔3. XML과 Java(어노테이션)를 같이 사용하여 스프링을 설정하고 컨테이너를 만들고 컴포넌트를 생성한다

### (1) xml 파일에 Java파일을 포함시켜 사용하는 방법

- xml에서 어노테이션 인식하기 : namespaces에서 context 체크

```
<context:annotation-config/> <!-- 클래스 내의 annotation 해석 -->
	<bean class="com.lec.ch03.method3.Method3_applicationConfig"/><!-- xml안에 자바 생성 -->
```

### (2) Java파일에 xml 파일을 포함시켜 사용하는 방법

- `@ImportResource("classpath:경로")` : 경로에 적은 xml 파일이 java에 포함된다

># ✨4. DI(Dependency Injection) 자동의존 설정과 빈 생명주기와 범위

## ✔1. 객체간 의존 자동 연결 : @Autowired

## ✔2. 스프링 컨테이너 생명 주기

- 스프링 컨테이너 생성 :  
  `GenericXmlApplicationContext ctx = new  GenericXmlApplicationContext();`
- 스프링 컨테이너 설정 : `ctx.load(“classpath:파일명”);`
- 객체 생성 : `ctx.refresh();`
- 스프링 컨테이너 사용 : `Student st = ctx.getBean(“student”,Student.class); st.getName();`
- 스프링 컨테이너 소멸(자원해제) : `ctx.close();

># ✨5. 외부파일(propertiesFile)을 이용한 설정

## ✔1. Environment 객체를 이용한 스프링 빈 설정

1. 외부 파일 생성
2. IOC 컨테이너 생성(환경변수가 자동 세팅(ENV:`Environment`))
`GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();`
3. ENV 객체 얻기   
 `ConfigurableEnvironment env =  ctx.getEnvironment();`

4. ps(properties Source, (`속성 : 값`)형식)이 ENV 객체에 속한다
- env의 속성과 속성값으로 되어있는 PS들 가져오기
`MutablePropertySources propertiesSources =  env.getPropertySources();`

5. 외부 파일을 읽어 ENV에 PS를 추가, 파일이 없을 수도 있으니 예외 처리 해주기
```
String resourceLocation = "classpath:META-INF/ex1/admin.properties";
		try {
			propertiesSources.addLast(new ResourcePropertySource(resourceLocation));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
```
---
6. IOC 컨테이너 안에 객체를 생성(class)
- 자동적으로 호출하기 : `EnvironmentAware`를 `implements`
- 만든 class 형 Bean(xml) 생성하기  

7. bean 생성(admin)을 위해 xml 파싱하고 객체생성
```	
  	ctx.load("classpath:META-INF/ex1/CTX.xml");
		ctx.refresh();
```		
8. bean 사용
```
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println("adminId : " + admin.getAdminId());
		System.out.println("adminPw : " + admin.getAdminPw());
		System.out.println("env : " + admin.getEnv());
		ctx.close();
```

## ✔2. properties File을 이용한 설정
- Environment 객체를 사용하지 않고 프로퍼티 파일을 직접 이용하여 스프링 빈을 설정하는 방법 
- 스프링 설정 XML 파일에 프로퍼티 파일을 명시하는 방법

1. properties 파일 생성

2. Environment 객체를 사용하지 않고 프로퍼티 파일을 직접 이용하여 스프링 빈을 설정
- xml - namespaces에서 context 체크
- properties 파일 가져오기  
`<context:property-placeholder location="classpath:META-INF/ex2/admin.properties, classpath:META-INF/ex2/sub_admin.properties"/>`
- `value`에 가져온 값 쓰기  
`<property name="변수이름" value="${properties에 있는 이름}"/>`

## ✔3.	프로파일(profile) 속성을 이용한 설정
- profile 속성을 사용하여 동일한 스프링 빈을 여러 개 만들어 놓고  
 상황(환경)에 따라서 적절한 스프링 빈을 사용할 수 있게 한다 

### 1. CTX(xml)를 개발용, 테스트용으로 나누어 생성
- 생성 시 `beans` 태그에 `profile="이름"` 추가  
동일 이름의 `bean`을 만들어도 충돌이 안 나기 위해 추가한다

- `<context:property-placeholder location="경로">`   
`context`안의 `location` : 외부 파일을 가져올 수 있다

### 2. `main class`
- 환경변수 null로 선언
- `Scanner` 이용하여 원하는 모드 입력받기  
- 환경변수에 입력받은 값 넣기
- 컨테이너 생성  
`GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();`
- 입력 받은 profile에 맞는 xml 파일 활성화  
`ctx.getEnvironment().setActiveProfiles(환경변수);`
- xml 파일 `load`하기 : `ctx.load(loc1, loc2);`
- 객체 생성 : `ctx.refresh();`
- `Bean` 가져오기  
`ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);`


># ✨6. AOP(Aspect Oriented Programming)
## AOP란?
- 핵심 기능과 공통 기능을 분리 시켜놓고, 공통 기능을 필요로 하는 핵심 기능들에서 사용하는 방식

## AOP 관련 용어
-	`Aspect` : 공통 기능. 예를 들어 로깅같은 기능 자체에 대한 용어
-	`Advice` : 공통기능을 구현한 객체 메
-	`Join Point` : 핵심기능. 공통 기능을 적용할 수 있는 대상.
-	`PointCuts` : Join Point의 부분으로 실제 Advice를 적용해야 되는 부분
-	`Proxy` : Advice가 적용되었을 때 만들어지는 객체
-	`Weaving` : Advice와 target이 결합되어서 프록시 객체를 만드는 과정(advice를 핵심기능에 적용하는 행위)

## 스프링에서 AOP 구현
- AOP의 구현은 proxy를 이용한다.
- Weaving 방식은 두가지
	1.	XML을 이용
	2.	@Aspect 어노테이션 이용

## AOP 구현 시 pom.xml에 의존 설정
```
<dependency>
	<groupId>org.aspectj</groupId>
	<artifactId>aspectjweaver</artifactId>
	<version>1.7.4</version>
</dependency>

<dependency>
	<groupId>cglib</groupId>
	<artifactId>cglib</artifactId>
	<version>2.2</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.18.24</version>
	<scope>provided</scope>
</dependency>
```


##	Advice의 종류
- `aop:before` : 핵심기능 메소드 **실행 전**에 advice 실행
- `aop:after-returning` : **정상적으로 핵심기능 메소드 실행 후**에 advice 실행
- `aop:after-throwing` : 핵심기능 **메소드 실행 중 exception(에러) 발생시** advice 실행
- `aop:after` : 핵심기능 **메소드 실행 후( exception이 발생여부에 상관없이 반드시** ) advice 실행
- `aop:around` : 핵심기능 **메소드 실행 전/후 및 exception 발생시** advice 실행 (가장 광범위하게 사용)


># ✨7. MVC

## ✔Spring MVC 기본 흐름
1. **웹브라우저를 통해** 클라이언트의 **요청이 들어오면 무조건 맨 처음 DisptcherServlet에서 요청을 받는다** 
2. **요청된 내용**을 **HandlerMapping**에게 작업을 보내 **요청 URL과 매칭되는 컨트롤러를 검색**해 준다.
3. 요청된 내용의 처리를 컨트롤러에게 요청한다
4. 요청된 내용을 Controller에게도 보내고 요청된 내용에 따라 다른 일을 하고, 컨트롤러 실행결과를 ModelAndView로 변환해서 리턴한다
5. 컨트롤러의 실행결과를 보여줄 View를 검색하기 위해 ViewResolver에게도 보낸다.
요청한 결과의 View로 응답 생성을 한다.
우리가 작업을 많이 할 부분은 Controller, View, Model이고 나머지 부분은 Spring에서 거의 자동으로 다루어준다. 
요청이 들어오면 DispatcherServlet 이 먼저 받고, Controller에게 요청을 한다. Controller에서 다시 DispatcherServlet으로 뭔가 응답을 준다. 그러면 DispatcherServlet에서 ViewResolver를 통해 View에 호출이 된다. 그러면 사용자에게 응답이 이루어 진다.
 

- web.xml 에서 한글처리 filter 추가하기
```
<!-- 한글처리 filter 추가  -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```

- css 링크 걸기  
모든 / 포함된 경로는 `DispatcherServlet`으로 간다 따라서 `DispatcherServlet` 안 가게 설정  
- servlet-context.xml에서  
  `<resources mapping="/css/**" location="/css/" />` 추가

># ✨8. Controller
## ✔ 1. Controller class 제작
### 1-1. `@Controller` 어노테이션을 clsss에 적용
	- 컨트롤러 역할의 클래스 파일은 `servlet-context.xml`에 `<context:component-scan base-package="com.lec.ch08" />  `명시된 패키지 아래에만 위치할 수 있다

### 1-2. `@requestMapping` 어노테이션을 이용해서 요청 경로를 지정
#### 요청 경로는 prefix + 요청경로 + suffix로 조합된다
- 공통 요청 경로 : `@Controller` 밑에 `@RequestMapping("공통요청경로")` 추가
- `@RequestMapping("요청경로")` 
- 요청방식(GET or POST) 지정하기   
: `@RequestMapping(value="요청경로", method = RequestMethod.GET 또는 POST)`

### 1-3. 웹브라우저의 요청을 처리할 메서드를 구현
```
public 리턴타입 메서드이름() {
		return "view 파일 이름";	
	}
```
- return 타입이 `ModelAndView`   

```
매개변수 없는 타입
------------------------
public ModelAndView list() {
		ModelAndView mav = new ModelAndView();	// 빈 ModelAndView 객체 생성
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("aaa", "111"));
		mav.addObject("list", list);  // mav에 추가
		mav.setViewName("board/list");  // view 지정
		return mav;	// view 리턴
	}

매개변수 있는 타입 : new ModelAndView();를 자동 생성
------------------------
public ModelAndView reply(ModelAndView mav) {
		Member member = new Member("ccc", "111");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;
	}
```

