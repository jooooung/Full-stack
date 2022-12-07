package com.lec.ConditionQuiz;
//수를 입력받아 절대값을 출력하는 프로그램
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");		
		int num = sc.nextInt();
		if(0>num) {
			System.out.println("입력한 수의 절대값은 = " + -num);
		}else {
			System.out.println("입력한 수의 절대값은 = " + num);
		}
		sc.close();
	}
}

//양수 입력시 그대로 출력, 음수 입력시 num 에 - 를 추가로 붙여 절대값이 되도록 만들었다.  
//실수 입력시 오류나는 현상이 생김 -> ???
