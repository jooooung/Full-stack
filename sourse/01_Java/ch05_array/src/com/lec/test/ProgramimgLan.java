package com.lec.test;

public class ProgramimgLan {
	public static void main(String[] args) {
		int [] num = {76,45,34,89,100,50,90,93};
		int total = 0;
		double avg = 0;
		for(int i=0 ; i<num.length ; i++) {
			total+=num[i];
			avg = (double)(total%num[i]);
		}
		System.out.println("합     계 = " +total+ "  평     균 = "+avg);
		int maxI=0, maxNum=0;
		int minI=0, minNum=9999;
		for(int i=0 ; i<num.length ; i++) {
			if(num[i] > maxNum) {       
				maxNum = num[i];
			}
			if(num[i] < minNum) {
				minNum = num[i];
			}
		}
		System.out.printf("최대값은 = %d  최소값은 = %d", maxNum, minNum);
	}
}
