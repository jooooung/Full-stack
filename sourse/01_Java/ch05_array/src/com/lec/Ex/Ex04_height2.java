package com.lec.Ex;

import java.util.Scanner;

public class Ex04_height2 {
	public static void main(String[] args) {
		String[] arrName = {"영희", "철수", "길동", "영수", "말자"};   //문자이기에 String 사용, 이름 저장 공간
		int[] arrHeight = new int[arrName.length];    //키를 이름 수 만큼 입력받을 공간 만들기
		Scanner sc = new Scanner(System.in);
		int totHeight = 0;         //총 합 키 변수 선언
		// 키 입력받기 -> totHeight에 누적
		for(int idx=0 ; idx<arrName.length ; idx++) {  //이름 수 만큼 반복
			System.out.print(arrName[idx]+"의 키는? : ");   //이름 + 의 키는? : 을 arrName[]만큼 반복 입력
			arrHeight[idx] = sc.nextInt();   //키 입력 칸
			totHeight += arrHeight[idx];  //입력받은 키 누적
		}
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.printf("%d번째 %s의 키는 %d\n", idx,  arrName[idx], arrHeight[idx]);
		}
		//System.out.println(arrName.length + "명의 평균키는" + (double)totHeight/arrHeight.length);
		System.out.printf("%d명의 평균키는 %.1f\n", arrName.length, (double)totHeight/arrHeight.length);
		sc.close();
		int maxIdx=0, maxHeight=0;  //최장신을 구하기 위한 변수들(작은 값으로 초기화)
		int minIdx=0, minHeight=9999;   //최단신을 구하기 위한 변수들(큰값으로 초기화)
		for(int idx=0 ; idx<arrName.length ; idx++) {
			if(arrHeight[idx] > maxHeight) {       //최장신
				maxHeight = arrHeight[idx];
				maxIdx = idx;
			}//if
			if(arrHeight[idx] < minHeight) {		//최단신
				minHeight = arrHeight[idx];
				minIdx = idx;
			}
		}//for
		System.out.printf("가장 큰 학생 %s의 키는 %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("가장 작은 학생 %s의 키는 %d\n", arrName[minIdx], minHeight);
	}//main
}//clase