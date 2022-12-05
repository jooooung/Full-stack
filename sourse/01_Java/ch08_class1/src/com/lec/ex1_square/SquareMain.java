package com.lec.ex1_square;

public class SquareMain {
	public static void main(String[] args) {
		Square s1 = new Square();  //s1이라는 새로운 Square 생성
		System.out.println("s1의 한 변은" + s1.getSide());
		s1.setSide(2);    
		System.out.println("수정된 s1의 넓이는 : "+s1.area());
		Square s2 = new Square(10);
		System.out.println("s2의 한 변은 " + s2.getSide());
		System.out.println("s2의 넓이는 " + s2.area());
	}
}
