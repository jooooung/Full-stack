//1 <= (int)(Math.random()*45)+1 < 46
package com.lec.ex3_math;

import java.util.Random;

// 0 <= Math.random() < 1 1의 double 난수
// Random random = new Random()
public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("1~45까지 정수 난수 : " + (int)(Math.random()*45+1));
		Random random = new Random();
		System.out.println("int 난수 : " + random.nextInt());  //정수 난수
		System.out.println("Double 난수 : " + random.nextDouble());  //실수 난수
		System.out.println("true/false 중 난수 : " + random.nextBoolean());
		System.out.println("0~100까지의 정수 난수 : " + random.nextInt(101));   // 0~100까지의 정수 난수
		System.out.println("1~45까지의 정수 난수 : " + (random.nextInt(45)+1));   // 0~100까지의 정수 난수
		System.out.println("가위(0), 바위(1), 보자기(2) 중 하나 : " + random.nextInt(3));
	}
}
