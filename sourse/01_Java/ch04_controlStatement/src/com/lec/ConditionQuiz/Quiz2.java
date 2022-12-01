package com.lec.ConditionQuiz;
//두 수 중 최대값 구하기
public class Quiz2 {
	public static void main(String[] args) {
		int num1 = 27;         				 //첫번째 수 입력
		int num2 = 27;     					 //두번째 수 입력
		int max;							 //두 수 중 최대값을 max라고 지정
		if(num1 > num2) {					 //if, else로 num1이 클 시, num2가 클 시 두가지 결과 지정
			max = num1;
		}else {
			max = num2;
			System.out.println("최대값은" + max);   //결과를 max로 출력
			if(num1 == num2) {
			System.out.println("두 수가 같음");
			}
		}		
	}
}
