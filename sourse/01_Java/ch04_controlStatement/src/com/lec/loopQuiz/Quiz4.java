package com.lec.loopQuiz;
//다음과 같은 출력형식의 구구단을 9단까지 출력하는 프로그램을 구현해 보자
//2*1=2	3*1=3	4*1=4	5*1=5	6*1=6	7*1=7	8*1=8	9*1=9	
//2*2=4	3*2=6	4*2=8	5*2=10	6*2=12	7*2=14	8*2=16	9*2=18	
//2*3=6	3*3=9	4*3=12	5*3=15	6*3=18	7*3=21	8*3=24	9*3=27	

public class Quiz4 {
	public static void main(String[] args) {
		for(int i=1 ; i<=9 ; i++) {
			for(int j=2 ; j<10 ; j++) {
				System.out.printf("%d * %d = %d\t",j, i, j*i);
				//System.out.println(j+"*"+i);
			}
			System.out.println();
		}
	}

}
