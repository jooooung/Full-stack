//width=10 height=5 인 도형의 데이터 출력
// 넓이 출력
package com.lec.ex;

public class RectMain {
	public static void main(String[] args) {
	Rect r1 = new Rect(10, 5);
	//System.out.println("r1 : "+ r1.area());
	Rect r2 = new Rect();
	//System.out.println("r2 : "+ r2.area());       //아직 r1, r2에 setter, getter를 안 했기에 0 
	Rect r3 = new Rect(7);
	//가로 세로 길이
	System.out.printf("r1의 데이터 : %d %d\n", r1.getWidth(), r1.getHeight());
	System.out.printf("r2의 데이터 : %d %d\n", r2.getWidth(), r2.getHeight());
	System.out.printf("r3의 데이터 : %d %d\n", r3.getWidth(), r3.getHeight());
	//r1.setWidth(10); r1.setHeight(5);
	//System.out.printf("r1의 데이터 변경 후 : %d %d\n", r1.getWidth(), r1.getHeight());
	//System.out.printf("r2의 데이터 : %d %d\n", r2.getWidth(), r2.getHeight());
	System.out.println("r1의 넓이 : " + r1.area());
	System.out.println("r2의 넓이 : " + r2.area());
	System.out.println("r3의 넓이 : " + r3.area());
	}
}
