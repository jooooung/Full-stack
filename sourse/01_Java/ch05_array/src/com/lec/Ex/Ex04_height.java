package com.lec.Ex;
//배열을 이용하여 학생들(영희, 철수, 길동, 영수, 말자)의 키를 입력받고, 평균치를 구해보자.
//가장 큰 키와 가장 작은 키인 사람 구하기
import java.util.Scanner;

public class Ex04_height {
	public static void main(String[] args) {
		String[] arrName = {"영희", "철수", "길동", "영수", "말자"};   //이름 저장 공간
		int[] arrHeight = new int[arrName.length];    //키 저장 공간
		Scanner sc = new Scanner(System.in);
		int totHeight = 0;
		// 키 입력받기 -> totHeight에 누적
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"의 키는? : ");
			arrHeight[idx] = sc.nextInt();
			totHeight += arrHeight[idx];  //누적
		}
		for(int idx=0 ; idx<arrName.length ; idx++) {
			System.out.printf("%d번째 %s의 키는 %d\n", idx,  arrName[idx], arrHeight[idx]);
		}
		System.out.println(arrName.length + "명의 평균키는" + (double)totHeight/arrHeight.length);
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
