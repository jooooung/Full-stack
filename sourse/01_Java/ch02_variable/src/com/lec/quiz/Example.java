package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		//국어, 영어, 수학 점수 할당
		int kor = 100;
		int eng = 90;
		int mat = 88;
		//총점, 평균
		int tot = kor + eng + mat;
		double avg = tot / 3. ;   
		//double을 쓰는 이유 : 평균은 소수점이 있으므로 8byte가 가능한 double 로 사용 
		//점수들 출력
		System.out.println("국어 : "+kor+"\t영어 : "+eng+"\t수학 : "+mat);
		System.out.printf("총점 : %d\t평균 : %.2f\n", tot, avg);	
	}
}


/*국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 
총점, 평균 출력하는 프로그램을 구현 하시오
(com.lec.ex패키지내에 작성한 Example.java를 yisy0703@naver.com으로 메일 발송 하시오).*/


