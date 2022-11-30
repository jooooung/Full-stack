package com.lec.condition;
// 실행할때마다 컴퓨터가 난수(Random)점수발생하여 학점 출력
public class Ex07_swich_RandomHakjum {
	 public static void main(String[] args) {
		//Math.random 은 0<= x <1 : 실수
		//0 <=(int)(Math.random()*3) < 3 : 실수      (정수를 출력하기 위해 (int)를 삽입)
		//0 <= score <101 사이의 정수 난수
		//System.out.println((int)(Math.random()*101));
//		int temp = score==100 ? score-1 : score;       // 100점도 A학점이 나오게끔 한 것
//		switch(temp/10){
//			case 9:
//				System.out.println("A학점");break;
//			case 8:
//				System.out.println("B학점");break;
//			case 7:
//				System.out.println("C학점");break;
//			case 6:
//				System.out.println("D학점");break;
//			case 5: case 4: case 3: case 2: case 1:
//				System.out.println("F학점");break;
//			default:
//				System.out.println("유효하지 않은 점수입니다");
//		}
//		sc.close();
	int score = (int)(Math.random()*101);
	int temp = (score==100) ? score-1 : score;       
	switch(temp/10){
	case 9:
		System.out.println(score + ", A학점");break;
	case 8:
		System.out.println(score + ", B학점");break;
	case 7:
		System.out.println(score + ", C학점");break;
	case 6:
		System.out.println(score + ", D학점");break;
	case 5: case 4: case 3: case 2: case 1: case 0:
		System.out.println(score + ", F학점");break;
	default:
		System.out.println(score + "유효하지 않은 점수입니다");
		}
	 }
}

