/*
복제 메소드 (Clone)  
사용 전에  Implemetns Cloneable 해주고 
복제 메소드 clone을 오버라이드해줘야한다
new Rectangle(10, 5, "빨강")   new(10, 5)  new Rectangle()  new Rectangle("노랑") 사각형 만들기
*/
package com.lec.ex4_object;

public class Rectangle implements Cloneable {
	private int width;
	private int height;
	private String color;

	public Rectangle() {
		color = "검정";
	}

	public Rectangle(String color) {
		this.color = color;
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		color = "검정";
	}

	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}

	@Override
	public String toString() { // 객체의 정보를 스트링으로 return
//		return "가로" + width + "cm" + "세로" + height + "cm의" + color + "색 사각형";
		return String.format("가로 %dcm 세로%dcm의 %s색 사각형", width, height, color);
	}

	@Override
	public boolean equals(Object obj) { // r1.equals(r2) => r1이 this, r2가 obj
		if (obj != null && getClass() == obj.getClass()) {
			Rectangle other = (Rectangle) obj; // Rectangle로 형변환한 obj를 other
			boolean widthChk = width == other.width;
			boolean heightChk = height == other.height;
			boolean colorChk = color.equals(other.color);
			return widthChk && heightChk && colorChk;
//			return width==other.width && height==other.height && color.equals(other.color);
		}
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
