# Interface
## 1. 인터페이스란
	- 작업명세서
      - 실제로 구현된 것이 없는 기본 설계도
      - 객체 생성 불가, 클래스 작성 시 꺼내 쓴다고 보면 된다
      - 미리 정해진 규칙에 맞게 구현하도록 표준을 제시
      - 추상메소드와 상수만 가능
   
	- 다형성 
      - 하나의 객체를 많은 타입으로 생성 가능
```
Class S{
			...
			public void method(){…}
		}
```
```
Class C extends S {
			...
			public void method(){…}
		}
		C c = new C()		//C에서의 c
		S s1 = new C();		//C에서의 s1
		S s2 = new S();		//S에서의 s2
		s1.method(); 
s2.method();
```
	- 객체를 부속품화 : 다양한 객체를 마음대로 변경 가능

## 2. 문법
	- class 대신 interface 사용
    - 추상메소드와 상수만 존재
```
public interface 인터페이스이름 {
		public static final 타입 상수이름 = 값;
		public abstract 메소드 이름(매개변수 목록);  //구현된 메소드는 가질 수 없다
	}
	//모든 멤버변수는 public static final이어야하며 static final은 생략할 수 있다.'
	//모든 메서드는 public abstract 이어야 하며, abstract를 생략할 수 있다.
```
	- private는 불가 : 상수나 메소드를 만들 때 private 접근 제한자는 불가
    - 변수 타입 : 인터페이스는 객체를 생성할 수 없다. 다만, 변수 타입으로만 사용 됩니다.
    - 구현은 Implement 되는 클래스에서 가능
## 3. 다형성
- 다형성이란? 여러가지 형태를 가질 수 있는 능력 -> 객체가 여러가지로 변할 수 있다
- 하나의 인터페이스를 사용하여 다양한 구현 방법 제공
- 오버로딩(overloading) : 같은 클래스 내에서만 오버로딩이라 할 수 있다.
- 메소드 overriding(다중정의) : 같은 이름을 가진 메소드를 다른 클래스에서 재정의 하는 법
```
   - overriding 조건 1. 선언부가 같아야 한다(이름, 매개변수, 리턴타입)
   				    2. 접근제어자를 같거나 넓게 사용하여야 한다. private>protected>public 
                    
 ※ 오버로딩 vs. 오버라이딩
 
	오버로딩(overloading) : 컴파일러 입장에서는 기존에 없는 새로운 메서드를 정의하는 것(new)
			              메소드 다중정의 (같은 class에서 동일한 메소드가 매개변수를 달리 여러 개 존재
                          
	오버라이딩(overriding): 상속받은 메서드의 내용을 변경하는 것(change, modify)
			메소드 재정의 : 부모클래스와 자식클래스에 동일한 method 존재(틀만 가져와 재정의)
```
## 4. 인터페이스와 다중상속
- java는 다중상속 불가 하지만 interface를 통하여 다중구현이 가능하다
1. 단일상속(O)
```
public class ChildClass extends ParentClass1 {

} 
```
2. 다중상속(X)
```
public class ChildClass extends ParentClass1, ParentClass2, ParentClass3 {

}
```
3. 다중구현(O)
```
public class ChildClass implements IFunction1, IFunction2, IFunction3 {

}
```
## 5. 인터페이스의 장점
1. 개발시간 단축 가능
2. 표준화 가능 : 기본 틀을 인터페이스로 사용
3. 서로 관계없는 클래스들을 연결할 수 있다
4. 독립적 프로그래밍 가능
## 6. 인터페이스와 추상클래스
(공통점)
1. 추상메소드를 가지고 있다 - 추상메소드를 가지고 있어 하위 클래스에서 구현해야 한다.
2. 변수 타입이 목적 - 객체생성이 목적이 아닌 변수 타입을 정의하는 것이 목적.
3. 객체 생성 불가. anonymose(익명클래스)를 이용할 수 있다.

(차이점)
1. 상속, 구현 - 추상메소드는 상속(extends)을 통한 사용이고, 인터페이스는 구현(implements)을 통한 사용
2. 구성요소 차이 - 추상클래스는 일반 클래스와 동일하게 변수, 메소드의 모든 기능을 사용할 수 있지만, 인터페이스는 상수와 추상메소드만이 존재
4. 단일상속, 다중구현 - 추상클래스는 상속이므로 단일 상속만 지원하고, 인터페이스는 다중구현이 가능