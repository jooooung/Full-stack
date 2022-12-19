package com.lec.Quiz_array;
//76,45,34,89,100,50,90,92  
//8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램을 작성 하시요.
public class Quiz4 {
	public static void main(String[] args) {
		int [] num = {76, 45, 34, 89, 100, 50, 90, 93};
		int i, j;
		int temp;
		for(i=0 ; i<num.length ; i++) {
			for(j=i+1 ; j<num.length ; j++) {
				if(num[i] > num[j]) {
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				}
			}//for-j
		}//for-i
		for (int k : num) {
			System.out.print(k + " ");
		}//확장for
	}//main
}
