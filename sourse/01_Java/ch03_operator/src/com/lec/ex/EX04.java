package com.lec.ex;
// 논리연산자 : &&(AND), ||(or), !
public class EX04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("&& : (i<j) && (++j>h) 는" + ((i<j) && (++j>h)));
		System.out.println("j = "+j); //j=11
		
		System.out.println("&& : (i>j) && (++j>h) 는" + ((i>j) && (++j>h)));
		System.out.println("j = "+j);  //&&연산의 경우 좌항값이 false인 경우 우항을 연산하지 않아 그대로 11
		
		System.out.println("|| : (i<j) || (++j>h) 는" + ((i<j) || (++j>h)));
		System.out.println("j = "+j); // ||는 좌항값이 true인 경우 우항 연산 x
		
		System.out.println("|| : (i>j) || (++j>h) 는" + ((i>j) || (++j>h)));
		System.out.println("j = "+j);
	}

}
