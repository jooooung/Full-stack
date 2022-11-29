package com.lec.ex;
//증감연산자 : ++(1증가), --(1감소)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1;  //n1을 1 증가하고 n2에 할당
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = n1++;      //n1값을 n2에 할당한 후 1증가
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = --n1;
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = n1--;
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		
		boolean result = !(n1!=n2);  //논리연산자(반대를 의미)  그냥 result를 쓰니 에러 -> boolean 추가
		System.out.println("!(n1!=n2!)는"+ result);   
	}
}

//n1 = 11, n2 = 11
//n1 = 12, n2 = 11
//n1 = 11, n2 = 11
//n1 = 10, n2 = 11
//!(n1!=n2)는false   -> 왜 !(n1!=n2) 그대로 이렇게 나오지?
