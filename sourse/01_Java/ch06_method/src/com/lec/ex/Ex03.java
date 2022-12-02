package com.lec.ex;

import com.lec.method.Arithmetic;
//Arithmetic 을 사용하기 위한 import
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9의 절대값 : " + Arithmetic.abs(-9));
		//default접근제한자는 같은 패키지만 사용 가능
		Arithmetic Ar = new Arithmetic();
		int tot = Ar.sum(10);
		System.out.println("합은" + tot);
		System.out.println(Ar.evenOdd(tot));
		tot = Ar.sum(10, 100);
		System.out.println("합은" + tot);
		System.out.println(Ar.evenOdd(tot));
	}
}
