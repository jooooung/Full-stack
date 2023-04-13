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
[✨9. FormData](#✨9-formdata)  
[✨10. request mapping](#✨10-request-mapping)  
[✨11. mvcboard](#✨11-mvcboard)  
[✨12. jdbc template](#✨12-jdbc-template)  
[✨13. file upload](#✨13-file-upload)  
w[✨14. mybatis](#✨14-mybatis-i)
# ✨ Spring 세팅하기
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

- Spring legacy project
	 - Simple Spring Utility Priject(web이 아닌 프로젝트)
	 - Spring MVC Project(web 프로젝트)
- next 후 다운로드 - default Package 이름 지정

- C:\Users\사용자이름\\.m2라는 폴더가 생성된다
- 프로젝트에 오류 시 우클릭 - Maven - Update

## ✔`dependencies`에 Lombok 추가하기

> <b>`dependency`란 객체 간의 관계를 의미</b>

- pom.xml : `dependencies`태그 - 사용 라이브러리 종류가 담아져있다
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
 그동안 `class`에서 직접 생성자나 getter를 만들어줬지만  
 Lombok을 사용하면 아주 편리하게 사용 할 수 있다.

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
## ✔ Controller class 제작
### 1. `@Controller` 어노테이션을 clsss에 적용
	- 컨트롤러 역할의 클래스 파일은 `servlet-context.xml`에 `<context:component-scan base-package="com.lec.ch08" />  `명시된 패키지 아래에만 위치할 수 있다

### 2. `@requestMapping` 어노테이션을 이용해서 요청 경로를 지정
#### 요청 경로는 prefix + 요청경로 + suffix로 조합된다
- 공통 요청 경로 : `@Controller` 밑에 `@RequestMapping("공통요청경로")` 추가
- `@RequestMapping("요청경로")` 
- 요청방식(GET or POST) 지정하기   
: `@RequestMapping(value="요청경로", method = RequestMethod.GET 또는 POST)`
#### ✔ 요청 경로가 Method인 경우
- `@RequestMapping(params = "method=xxx")`   

### 3. 웹브라우저의 요청을 처리할 메서드를 구현
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

># ✨9. FormData
스프링에서 폼에 있는 데이터 처리하기
## ✔1. `HttpServletRequest` 이용하여 form 데어터 전송(파일첨부 시 사용) 
```
@RequestMapping(value="join1", method = RequestMethod.GET)
	public String join1(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");  // request로 데이터 받기
		model.addAttribute("name", name);  // model에 add
		return "member/result1";	// view에 리턴
	}
```

## ✔2. `@RequesParam` 어노테이션을 이용해서 데이터를 전송받기
```
@RequestMapping(value="join2", method = RequestMethod.GET)
	public String join2(@RequestParam("name") String memberName, Model model) {
		model.addAttribute("name", memberName);
		return "member/result1";
	}
```

## ✔3. 데이터(커맨드) 객체를 이용하여 데이터가 많을 경우 간단하게 사용
로그인 등 전체 데이터가 필요하지 않을 때 사용
```
@RequestMapping(value="join3", method = RequestMethod.GET)
	public String join3(String name, Model model) {
		model.addAttribute("name", name);
		return "member/result1";
	}
```

## ✔4. 데이터 커맨드를 이용한 개선 방법 : 코드 양이 적다
```
@RequestMapping("member/join4")
	public String input4(MemberDto memberDto, Model model) {
		//스프링프레임워크가 자동으로 MemberInfo 객체 생성 후 setter를 이용하여 속성을 setting
		model.addAttribute("member",memberDto);
		return "member/result4";
	}
```

## ✔5. class 이름과 변수 이름은(첫글자는 소문자)같아야한다

```
@RequestMapping("join5")
	public String join5(MemberDto memberDto) { 
		return "member/result5";
	}
```
## ✔6. 따라서 대게 MemberDto가 아닌 Member로 생성  
MemberDto일 시 member로 지정하기  
= 매개변수에 `@ModelAttribute('모델 이름') `
```
public String join6(@ModelAttribute("member") MemberDto memberDto) {
		return "member/result4";
	}
```

## ✔ `@ModelAttribute` 란?
- 모든 요청경로에 공통으로 필요한 model attribute가 있을 경우 사용
- `@ModelAttribute(“모델이름선언”)`을 이용하면 자동적으로 모든 요청경로를 수행하기전   
`model`객체안에 `attribute Add`와 `setting`이 동시에 된다

># ✨10. Request Mapping
- 이 전까지 mapping은 "xxx" 였다. 오늘은 "xxx.do"로 하는 법을 알아보자

## ✔ index.jsp - main.do 처리하기
- web.xml - `servlet-mapping`의 `url-pattern`을 `/` 에서 `*.do` 로 변경
- index.jsp 만들어서 `main.do`로 `forward`
- `controller`에서 `main.do` 매핑 처리하기
- `views`에 main.jsp 생성

## ✔ `@RequestMapping` get / post 분리하기
- 동일한 `@RequestMapping`을 get과 post 두 가지로 만든다
1. 메소드 이름 동일하게 : 매개변수를 다르게
2. 메소드 이름을 다르게 만들기

## ✔ `redirect`
- 입력하거나 넘겨주는 요청값(`model attribute`)이 필요 없이 controller 단을 호출할 때
- `return "redirect:studentOk.do";` : model에 요청값이 넘어가지 않는다
- `fullPath` 사용
`return "redirect:http://www.naver.com";`

## ✔ `forward`
- 요청값(model attribute)도 함께 넘겨주면서 controller단을 호출할 때
- `return "forward:studentNg.do";` : model에 요청값이 넘어간다
- forward 시 forward한 메소드의 방식과 같은 방식이 있어야한다

## ✔ 더미데이터 넣기
- webapp - 폴더 생성 - jsp 파일 생성
- webapp에서 jsp 파일을 생성하면 jsp를 직접 실행 가능하다

># ✨11. mvcBoard 

## ✔ Controller
- 서비스 변수 선언 `private service이름 변수이름;`
### 🔸글목록
- **`controller`** 
	- model에 `pageNum` 전달 : `model.addAttribute("pageNum", pageNum);`
- **`service`**
	- pageNum 가져오기 : `Map<키값, value> map이름 = model.asMap();`  //model을 map으로 변경
	- `pageNum` 선언 : `String pageNum = (String) map.get("pageNum");`
  - `paging` 작업(순번, 역순 추가)
- **`jsp`**
	- 글쓰기 링크 경로 변경 : `writeView.do` => `mvcBoard/write.do`
	- 순번, 역순 변수선언 후 추가
	- for문 끝나기 직전 `순번 + 1`, `역번 - 1` 해주기

### 🔸글쓰기
- **`controller`** 
	- write 메소드 post로 생성 : form태그의 `method="post"`이기 때문	
	- 매개변수에 `dto`, `request`, `model` 추가
	- `request` : service 에서 ip 추출 용도
	- model에 request 추가 : `model.addAttribute("request", request);`
	- `return "forward:list.do";`
	- `return`을 `redirect`로 할 시 alert가 안 뜬다
	- POST 방식을 받는 list 매핑 추가
- **`service`**
	- model을 map화 하기
	- map으로 `dto`, `request` get
	- ip 세팅
	- model에 `addAttribute`

### 🔸상세보기
- **`controller`** 
	- 매개변수 : 글번호, model 
- **`service`**
	- model을 map화
	- map으로 `bid` get
	- model에 `addAttribute`

### 🔸글 수정, 답변 뷰 페이지
- **`controller`** 
	- model 에 `bid` add
- **`service`**
	- model을 map화
	- map으로 `bid` get
	- model에 `addAttribute`

### 🔸글 수정저장
- 글쓴이, 제목, 내용, ip 수정
- **`controller`** 
	- `POST` 방식 `@RequestMapping` 추가
	- - 매개변수에 `dto`, `request`, `model` 추가
	- `request` : service 에서 ip 추출 용도
	- model에 request 추가 : `model.addAttribute("request", request);`
	- `return "forward:content.do";` : 상세보기 페이지로 가기
	- `content.do`에 POST 방식 추가
- **`service`**
	- model을 map화
	- map으로 `dto`, `request` get
	- ip 설정 : `request.getRemoteAddr()` 이용
	- model에 `addAttribute`

### 🔸글 삭제
- **`controller`** 
	- model 에 `bid` add

- **`service`**
	- model을 map화
	- map으로 `bid` get
	- `delete` 결과 변수 생성
	- 결과에 따른 alert 멘트 설정 후 model 에 add 
	- model에 `addAttribute` 

### 🔸답글 쓰기
- **`controller`** 
	- `POST` 방식 `@RequestMapping` 추가
	- - 매개변수에 `dto`, `request`, `model` 추가
	- `request` : service 에서 ip 추출 용도
	- model에 request 추가 : `model.addAttribute("request", request);`
	- `return "forward:list.do";` : 상세보기 페이지로 가기
 **`service`**
	- model을 map화
	- map으로 `dto`, `request` get
	- ip 설정 : `request.getRemoteAddr()` 이용
	- model에 `addAttribute`

># ✨12. JDBC Template
`JDBC Template`을 이용한 db연결 -> 반복 코드를 줄이기 위해 사용
- JDBC 드라이버 로드 : `DriverManager`
- 데이터 베이스 연결 : `Connection`
- SQL문 실행 : `PreparedStatement`, `ResultSet`
- DB 연결 해제 : `close()`  
위의 과정을 **`JDBC Template`을 이용하여 한 번에 해결** 할 수 있다.
	- `JDBC Template`을 이용하면 server-context.xml에서 사용한  
	connection Full 과정 생략 가능

## ✔1. JDBC Template 사용을 위한 dependencies 추가
pom.xml에서 `springframework-version`확인 후  
동일 버전의 `jdbc`를 maven 사이트에서 취약점 확인 후 사용
```
<!-- spring-jdbc -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jdbc</artifactId>
		    <version>${org.springframework-version}</version>
		</dependency>
```

## ✔2. db.properties 파일 생성 후 `OracleDriver` 연결
src/main/resources - META-INF - property 폴더 생성 후 파일 생성
```
db.driverClassName=oracle.jdbc.driver.OracleDriver
db.url=jdbc:oracle:thin:@localhost:1521:xe
db.username=원하는 이름
db.password=원하는 비번
```

## ✔ 3. bean(객체) 추가
- web 관련 bean(객체) :  servlet-context.xml에 추가
- db 관련 bean(객체) : root-context.xml에 추가

### root-context.xml
- Namespaces에서 context 체크
- `dataSource` bean 추가
```
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="${db.driverClassName}"/>
		<property name="url" value="db.url"/>
		<property name="username" value="db.username"/>
		<property name="password" value="db.password"/>
	</bean>
```
- `template` bean 추가
```
	<bean name="template" class="org.springframework.jdbc.core.JdbcTemplate">
		<property name="dataSource" ref="dataSource"/>
	</bean>
```

## ✔ controller
- static 변수 `template` 생성 후
```
@Autowired	// root-context.xml의 bean 연결
	public JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		Constant.template = template;
		this.template = template;
	}
```

## ✔ DAO에서 사용하기
- `template` 변수 추가
- 생성자 함수에 `template = Constant.template;` 추가
- update, delete, insert 방법 : `template.update(sql, ? 채우는 객체)`
- `Object` : template.queryForObject(sql, 가져올 object 타입 세팅)
- 배열 : template.query(sql, ? 채우는 객체, Arraylist) ---------------------

## ✔ update, delete, insert
- ? 없는 경우 : `return template.update(sql);`
- ? 있는 경우
  - 방법 1 : `PreparedStatementSetter()` 추가 후 ? 세팅
```
return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bid);  
				// ? 세팅하기 => 매개변수(bid)를 final 변수로 변경해야 함
			}
		});
```

- 방법 2
```
return template.update(new PreparedStatementCreator() {
			String sql = "SQL문";
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, 매개변수);  // ? 세팅
				return null;
			}
		});
```

## ✔ select
- return 타입이 Object  
```
return template.queryForObject(sql, Integer.class); 
```
- return 타입이 ArrayList
```
return (ArrayList<BoardDto>) template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, startRow);
				ps.setInt(2, endRow);
			}
		},new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
```

># ✨13. File upload
## ✔ 1.	Pom.xml에 의존추가 
- maven 사이트에 Apache Commons FileUpload 검색
```
<!-- 파일업로드 -->
		<dependency>
		    <groupId>commons-fileupload</groupId>
		    <artifactId>commons-fileupload</artifactId>
		    <version>1.5</version>
		</dependency>
```

## ✔ servlet-context.xml 
1. `mapping`  변경 : `<resources mapping="/upload/**" location="/upload/" />`
2. `context:component-scan` 추가 :  `<context:component-scan base-package="com.lec.ch13" />`
3. `multipartResolver Bean` 생성
```
<beans:bean id="multipartResolver"
	class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	<beans:property name="maxUploadSize" value="1048576"/>	<!-- 최대 업로드 용량 1MB 설정 -->
</beans:bean>
```
## ✔ Controller
1. Service형 변수 생성 후 `@Autowired`
2. 업로드 페이지 `@RequestMapping`
- 업로드 매핑은 value값은 동일, 업로드 페이지는 method = GET 방식, 결과 페이지는 POST 방식
- `MultipartHttpServletRequest` 이용하여 파일 업로드
```
public ModelAndView fileup(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		if(fService.fileUp(mRequest, mav)) {  // 파일 업로드 추가
			mav.addObject("fileUpResult", "파일 업로드 성공");
		}else {
			mav.addObject("fileUpResult", "파일 업로드 안 됨");
		}
		mav.setViewName("fileResult");		// 뷰 페이지 설정
		return mav;
	}
```

## ✔ Service
### `boolean` 타입 생성자 생성
- `MultipartHttpServletRequest`에 들어온 파일을 서버에 저장 -> 소스폴더로 복사
- `uploadPath`: 업로드 파일, `backupPath`: 저장될 파일 지정 
- 업로드 파일 받을 배열 변수 생성
- 파라미터의 파일 객체 가져온 후 파일 이름 중복 시 처리하기
- 첨부파일 서버에 저장 -> 소스 폴더로 파일 복사

># ✨14. Mybatis-I
- MyBatis는 DB접근(SQL)을 자바가 아닌 xml로 대체하도록 하는 라이브러리
- SQL 코드를 자바코드와 분리시키는데 목적

## ✔1. dependency 추가하기
- `lombok`, `spring-jdbc`, `mybatis`, `mybatis-spring`

## ✔2. 한글 인코딩, servlet-mapping 수정
- web.xml : url-pattern - *.do  설정, 한글 처리 필터 추가

## ✔3. DB 환경설정 : db.properties
```
db.driverClassName=oracle.jdbc.driver.OracleDriver
db.url=jdbc:oracle:thin:@localhost:1521:xe
db.username=scott
db.password=tiger
```
## ✔4. root-context.xml에 dataSource 빈생성
```
// db.properties `context` 하기
<context:property-placeholder location="classpath:META-INF/property/db.properties"/>		
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	<property name="driverClassName" value="${db.driverClassName}"/>
	<property name="url" value="${db.url}"/>
	<property name="username" value="${db.username}"/>
	<property name="password" value="${db.password}"/>
</bean>
```

## ✔5. DTO 생성
- `@Data`, 변수 선언

## ✔6. xml 생성 :mapper + config
- https://mybatis.org/mybatis-3/configuration.html#objectFactory 에서 mapper정의 가져오기
```
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="이름 지정">
	<resultMap type="Dept" id="DeptResult">
		<result property="deptno" column="deptno"/>
		<result property="dname" column="dname"/>
		<result property="loc" column="loc"/>
	</resultMap>
	<!-- select 태그의 id는 유일해야 한다 -->
	<select id="deptList" resultMap="DeptResult"><!-- resultMap은 결과가 배열일 때 많이 쓴다 -->
		<![CDATA[	
			SELECT * FROM DEPT
		]]>	<!-- CDATA는 sql문에 연산자가 있을때 사용 -->
	</select>
</mapper>
```
## ✔6. root-context.xml에 SqlSessionfactoryBean, sessionTemplate(SqlSessionTemplate) 빈생성
```
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="configLocation" value="classpath:META-INF/sqlmap/config/mybatis-config.xml"/>
	</bean>
	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory"/>
	</bean>
```
## ✔7. DAO
- interface에 List 형 메소드 생성 : `public List<DTO> 이름();`
- interface를 `implements` 받는 class 생성
	- `@Repository` 선언 
	- SqlSession 변수 생성 : `@Autowired` 하기
```
	@Override
	public List<DTO> 메소드명() {
		return sessionTemplate.selectList("메소드명");
	}
```

## ✔8. Service
- interface : DTO 타입의 메소드 생성 `public List<DTO> 메소드명();`
- Service interface를 implements받는 class 생성 
	- dao 변수 선언 : `@Autowired`
	- `@Override` 받은 메소드 만들기
## ✔9. Controller
- interface Service 변수 `@Autowired`
- service에서 생성한 메소드 `@ModelAttribute`
- `@RequestMapping` 생성

## ✔10. view 페이지
- input, select : jquery로 submit 이벤트 걸기
- 컨트롤러에서 @ModelAttribute한 이름으로 데이터 출력

># ✨15. Mybatis-II
## ✔사원 관리 페이지 만들기
- 페이징된 사원 목록
- 사원 등록
- 사원 상세정보, 수정, 삭제

### 1. pom.xml `dependency` 추가
- lombok
- JDBC template
- myBatis
- mybatis-spring
### 2. web.xml 한글 필터 추가, url 매핑 `*.do` 변경
### 3. webapp/index.jsp 생성
- 원하는 경로로 `forward`
### 4. controller 생성 후 `forward`된 경로 생성
### 5. property - db.properties 생성 : DB 연결 설정
### 6. root-context.xml : db context, bean 생성
- context : db파일 `location` 지정
- `dataSource` bean 생성
- `sqlSessionFactory` bean 생성 
### 7. dto 생성
### 8. mybatis-config.xml : `typeAlias`, `mapper` 연결
### 9. mapper(xml) 파일 생성 -> sql 추가하기
- `sqlSessionTemplate` bean 생성
### 10. dao 생성
- dao interface : xml의 sql 수 만큼 생성 =>
`public xml의 resultMap id(parameterType이 있다면 서술);`
- dao class 
	- interface를 impl
	- `SqlSessionTemplate`을 `Autowired` 하는 변수 생성 
	- `Override` 받은 메소드에 `return`
### 11. utill 패키지 - `paging` class 생성
- Paging 함수 만들기
### 12. Service 
- interface 
	- dao에서 만든 메소드 가져오기
	- dummyData 용 void 함수 생성
- class
	- `@Service` : 스프링컨테이너에게 서비스임을 알려주는 어노테이션(빈생성)
	- `@Autowired` 하여 dao 가져오기
	- Override 메소드 재정의 (paging)
	- dummyData 메소드 재정의
### 13. Controller
- EmpService @Autowired
- 매핑 처리

### 14. 직원목록 페이지
- `foreach` 로 직원 데이터 출력
- `paging` 출력
- 상세보기 페이지로 가기 위한 tr에 click 이벤트
	1. `script6`
	2. `jQuery`
### 15. 직원정보 상세보기
- controller에서 넘어온 empDto 또는 param으로 데이터 출력
### 16. 직원정보 수정
- View용, 수정 정보 저장용 매핑 따로 두기  
 -> 글자수 제한 event 걸기 위해
	- 관리자사번, 보너스 null 에러 처리 : int -> String으로 변경하여 빈 스트링 입력 가능
	- 이름 

># ✨16. Mybatis-III
- Dao를 interface로 대체하는 방법
- `mybatis-spring`의 버전이 높아야한다

## 1. Servlet-context.xml에 mybatis-spring 추가
- 추가 전 네임스페이스에서 `mybatis-spring` 체크
- `<mybatis-spring:scan base-package="com.lec.ch14.dao(dao 패키지 경로)"/>`
## 2. dao interface에 `@Mapper` 추가

## 3.	Mapper xml파일에 namespace를 DAO interface로 수정 
- xml파일의 id와 DAO의 method이름은 일치
- `<mapper namespace="com.lec.ch14.dao.dao파일명">`

# ✨17 Mybatis-Board
Mybatis를 이용한 최종 완성 형식의 spring 게시판 만들기
## 작업순서
### 1. Qeury
- sql : 테이블 생성, 필요한 쿼리 만들기
- db 연결하는 properties 생성
### 2. pom.xml에 필요한 dependency 추가 : `lombok`, `spring-jdbc`, `mybatis`, `mybatis-spring`
### 3. web.xml : 한글 필터링 *.do  
### 4. Dto : 변수 선언, `@Data`
### 5. Board.xml(mapper)
- config
	-  `typeAliases` >  `typeAlias` 의 type으로 dto 경로 지정, `alias` 지정
	- `mappers` > `mapper` 의 `resource="META-INF/sqlmap/mappers/매퍼파일.xml"`
- mappers
	- https://mybatis.org/mybatis-3/configuration.html#objectFactory 에서 mapper정의 가져오기
	- `<mapper>`의 `namespace="dao 경로"`
		- `<resultMap>` : type="config에서 지정한 alias, id 지정
			- `<result>` : property, column(DTO의 변수)
	- query 태그
		- select
			- id 지정
			- `parameterType` : 
		- insert, delete, update
### 6. Config
### 7. 빈 생성
### 8. Mybatis-spring 추가
### 9. Dao 인터페이스 
### 10. Service











----

# ✔ alert 바꾸기 
## 1.SweetAlert
- CDN : `<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>`
- alert 대신 `swal('제목', '내용', '아이콘');`
- 아이콘 : `warning`, `error`, `success`, `info`

## 2. SweetAlert2
- CDN : `<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>`
```
Swal.fire({
				  title: '제목',
				  icon: '아이콘',
				  showCancelButton: 취소버튼유무 true/false,
				  confirmButtonColor: '컨펌버튼 색상',
				  cancelButtonColor: '취소버든 색상',
				  confirmButtonText: '컨펌버튼 글',
				  cancelButtonText: '취소버튼 글'
				}).then((result) => {	 
				  if (result.isConfirmed) {		
				  	 // 컨펌 시 할 것 지정
				  }
				})
```
# ✔ 에러
-  `servlet-context.xml`  404 에러    
context:component-scan 의 base-package를 프로젝트가 아닌 더 깊게 설정시 실행 에러
## ✔
## ✔
## ✔