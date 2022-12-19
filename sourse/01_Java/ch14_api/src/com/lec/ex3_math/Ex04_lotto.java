package com.lec.ex3_math;

import java.util.Random;

//0<= Math.random() < 1 : 실수 
//0<= Math.random()*45 <45 : 실수
//1<= (int)(Math.random()*45+1) <46 : 1~45까지의 정수
public class Ex04_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];      //lotto 6자리 방 만들기
		int i, j;
		int temp;    //난수 변수
		Random random = new Random();
		for(i=0 ; i<lotto.length ; i++) {
			do { //발생된 난수가 중복되었는지 체크
				temp = random.nextInt(45)+1;	//temp = (int)(Math.random()*45+1); 
				for(j=0 ; j<i ; j++) {    
					if(lotto[j] == temp) {
						break;
					} // if - temp랑 같은 번호가 있으면 for문을 빠져나감.
				}
			}while(i != j);
			lotto[i] = temp;
		}
		//발생된 로또 번호 출력 (20.33과 20.45는 똑같이 20으로 중복)
		for(int l : lotto) {
			System.out.print(l + "\t");
		}
		System.out.println("\n오름차순");
		//lotto 배열 값을 sort(작은 값부터 차례대로)
		for(i=0 ; i<lotto.length-1 ; i++) {
			for(j=i+1 ; j<lotto.length ; j++) {
			 if(lotto[i] > lotto[j]) {
				 temp = lotto[i];
				 lotto[i] = lotto[j];
				 lotto[j] = temp;
			 		}//if i>j
			 	}//for-j
			}//for-i
		for(int l : lotto) {
			System.out.print(l + "\t");
		}
	}//main
}//class
