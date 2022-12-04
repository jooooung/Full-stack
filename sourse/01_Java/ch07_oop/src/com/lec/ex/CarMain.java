//myPorsche, urPorsche 만들고 빨강, 진회색 color 설정 
//myPorsche cc설정 후 "myPorsche color 차량 배기량 : cc" 출력하기
//myPorsche drive, park, race 출력하기
package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car(); // Car를 이용하여 myPorsche 만들기
		myPorsche.setColor("빨강");
		myPorsche.setCc(2000);
		System.out.println(myPorsche.getColor() + "색 차량 배기량 : " + myPorsche.getCc());  //setColor를 getColor로 불러오기, setCc 를 getCc로 가져오기
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car urPorsche = new Car(); // Car를 이용하여 urPorsche 만들기
		urPorsche.setColor("진회");
		urPorsche.drive();
		System.out.println("내 차 속도 : " + myPorsche.getSpeed()); // 마지막 속도가 race의 120이었기 때문에 getSpeed = 120
	}
}

//myPorsche 와 urPorsche의 drive 속도가 다를 시 drive가 아닌 다른 변수를 만들어 사용해아 하나?