// 속성, 생성자, 메소드, getter&setter(외부에서 가져오지 않으면 사용x)
// Square s = new square();  s라는 새로운 square 생성, s의side는 0으로 초기화
// Square s1 = new square(10);  // s의side를 10으로 초기화하면서 객체 생성
package com.lec.ex1_square;

public class Square {
	private int side; // side 라는 가로세로 변수 생성

	public Square() { // 매개 변수 없는 Square 함수 생성
		System.out.println("매개변수 없는 생성자 함수 호출");
	} // 생성자 함수 : return type 없고 클래스명과 같은 함수

	public Square(int side) { // 매개변수가 있는 생성자 함수 용도 : 데이터의 초기화
		this.side = side;
		System.out.println("매개변수 있는 생성자 함수 호출");
	}

	public int area() { // 넓이를 구하는 area 생성
		return side * side;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
}
