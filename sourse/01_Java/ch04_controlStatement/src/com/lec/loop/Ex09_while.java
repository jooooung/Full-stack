package com.lec.loop;
//1~100까지 숫자중의 3의 배수의 합을 출력
public class Ex09_while {
	public static void main(String[] args) {
		int tot = 0;
		int i = 0;
		while(++i <= 100) {  //100까지의 수 중에
			if(i%3 ==0) {
				tot += i;
			}
//			if(i%3 != 0) {   //3의 배수가 아니면
//				continue;    //다시 while 문으로
//			}
//			tot += i;
		}
		System.out.println(tot);
	}
}
