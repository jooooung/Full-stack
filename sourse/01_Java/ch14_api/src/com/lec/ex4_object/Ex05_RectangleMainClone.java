//같은 패키지 내에 clone 이 있기에 사용 가능
package com.lec.ex4_object;

public class Ex05_RectangleMainClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle(); // r1 : w=0, h=0, color=검정
		r1.setHeight(5);
		r1.setWidth(10); // w=10, h=5, color=검정
		Rectangle r2 =  (Rectangle) r1.clone(); // 주소 복사 
		if (r1.equals(r2)) {
			System.out.println("같은 내용의 사각형 객체(복제인지 복사인지?)");
		} else {
			System.out.println("다른 내용의 사각형 객체");
		}
		if (r1 == r2) {
			System.out.println("복제한게 아니고 복사");
		} else {
			System.out.println("다른 주소");
		}
		if (r1 != r2 && r1.equals(r2)) {   //clone하였으니 복제 성공
			System.out.println("복제 성공");
		} else {
			System.out.println("복제 실패");
		}
	}
}
