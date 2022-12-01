package com.lec.Quiz_array;
//배열에 담긴 값을 더하는 프로그램을 작성
//int[] arr =  { 10, 20, 30, 40, 50}
public class Quiz1_tot {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int tot = 0;
		for(int i=0 ; i<arr.length  ; i++) {
			tot+=arr[i];
		}
		System.out.println("tot ="+tot);
	}
}
