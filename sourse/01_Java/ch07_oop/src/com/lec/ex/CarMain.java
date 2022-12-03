package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car(); // Car를 이용하여 myPorsche 만들기
		myPorsche.setColor("빨강");
		System.out.println(myPorsche.getColor() + "색 차량 배기량 : " + myPorsche.getCc());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car urPorsche = new Car(); // Car를 이용하여 urPorsche 만들기
		urPorsche.setColor("진회");
		urPorsche.drive();
		System.out.println("내 차 속도 : " + myPorsche.getSpeed());
	}
}
