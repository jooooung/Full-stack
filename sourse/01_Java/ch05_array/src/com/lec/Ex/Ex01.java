package com.lec.Ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;     //변수 선언, 초기화
		//1. 배열 변수 선언, 초기화 하기
		int[] iArr = {10, 20, 30, 40, 50};    //[] 는 배열을 의미, 배열이므로 여러가지 값 선언, 초기화
		iArr[2] = 300;  //배열은 index로 접근(0부터 시작)
		for(int idx=0 ; idx<iArr.length ; idx++) {      //length는 배열 방의 갯수
		System.out.println(iArr[idx]);
		}
		
		//2.배열선언과 배열 생성(메모리 할당)
		int[] iArr2 = new int[5];	//iArr2 의 배열 방을 5개 만듬
		iArr2[0] = 10;
		for(int idx=0 ; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		
		//3.배열 변수 선언
		int[] iArr3;   //변수 선언
		iArr3 = new int[3];		//배얼 메모리 할당
		
		//4.확장 for문
		for(int temp : iArr3) {
			System.out.println(temp);
		}
		//배열 방의 값 변경 - 일반for문
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			iArr3[idx] = 999;
		}
		for(int idx=0; idx<iArr3.length ; idx++) {
			System.out.println(idx + "번째 : " + iArr3[idx]);
		}
		//배열 방의 값 변경 - 확장for문
		for(int ia : iArr3) {
			ia = 111;
		}
		for(int ia : iArr3) {
			System.out.println(ia);
		}
	}
}
