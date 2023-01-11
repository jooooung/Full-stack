# 객체지향 프로그램(oop-object-oriented programming)
## 객체의 개념과 클래스의 이해
- 객체는 관련성 있는 데이터와 메소드의 구성체
- 클래스를 만들고 클래스 안에서 객체를 생성한다.  
따라서 클래스는 객체를 만들기 위한 설계도라 할 수 있다

```
ex)
public class Car {
	String color;
	int cc;
	String brand;
	int speed;
	void drive(){
		speed = 60;
		System.out.println("운전한다. 지금 속도 : "+speed);
	}
}
```
- ```Car class```를 만들고 그 안에 ```color, cc, brand```라는 데이터와 ```drive```라는 매개변수 없는 메소드를 만들었다.  
데이터와 메소드를 합쳐서 객체라고 한다  
- ```myPorsche```객체를 만들어 ```myPorsche.drive();```메소드와 ```myPorsche.color = "red";```  데이터를 설정해보았다
```
public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.drive();
		Car yourPorsche;
		myPorsche.color = "red";
	}
}
```