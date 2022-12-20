package com.lec.ex2_human;

import com.lec.ex2_human.kid.Kid;  
//*는 ex2_human 밑에 있는 클라스를 모두 사용한다
//ctrl shift o = 불필요한 import 제거
public class HumanMain {
	public static void main(String[] args) {
		Woman woman1 = new Woman();
		Woman woman2 = new Woman();
//		---------------------------
		//레퍼런스 변수 선언 = 객체생성(인스턴스 생성)
		System.out.println("woman1과 woman2가 같은지" + (woman1 == woman2));
		System.out.println("woman1과 woman2가 같은지" + woman1.equals(woman2));
		//객체끼리 비교시 equals 사용
		Kid kid = new Kid("홍아기");
		Man hong = new Man("홍길동");
		Man kim = new Man("김길동", 22, 170, 67);
		Man kim2 = kim;
		
		kim2.setHeight(185);
		kim2.setWeight(300);
		System.out.println("kim과 kim2가 같은 객체인지 " + kim.equals(kim2));
		double bmi = kim.calculateBMI();
		System.out.println(kim2.getName()+"의 bmi지수는" + bmi);
	}
}
