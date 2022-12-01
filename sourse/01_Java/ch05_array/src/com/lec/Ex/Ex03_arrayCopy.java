package com.lec.Ex;

public class Ex03_arrayCopy {
	public static void main(String[] args) {
		int [] score = {10, 20, 30, 40, 50};
		int [] s = new int[score.length];         //s에 score를 복제
//		for(int idx=0 ; idx<s.length ; idx++) {
//			s[idx] = score[idx];
//		}
		System.arraycopy(score, 0, s, 0, score.length);
		//(원본배열객체, int 원본시작위치, 복사본배열객체, int 복사본시작위치, int 복사길이)
		s[0] = 999;
		for(int idx=0 ; idx<s.length ; idx++) {
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", idx, score[idx], idx, s[idx]);
		}
	}
}
