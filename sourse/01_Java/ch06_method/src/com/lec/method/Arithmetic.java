package com.lec.method;
// sum(int, int)  매개변수 2개를 만들면 반드시 호출시에도 2개 ex sum(1, 2)
// sum(int)   함수의 오버로딩 : 똑같은 변수를 만들 수 있음(매개 변수를 다르게)
// evenOdd(n)  짝수 홀수 판단
// abs(n)   절대값
public class Arithmetic {
	public int sum(int from, int to) { //from~to까지 정수 누적 값(return)
		int result = 0; //누적변수
		for(int i=from ; i<=to ; i++) {
			result +=i;
		}
		return result;
	}//매개변수 2개인 sum
	public int sum(int to) {
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}//매개 변수 1개인 sum
	public String evenOdd(int value) {  //evenOdd를 짝 홀로 출력해야 하니 String 사용
		return value%2==0 ? "짝수입니다" : "홀수입니다";  
	}//짝수 홀수 판단
	public static int abs(int value) { //절대값을 return. 
	//접근제한자(public 등) 생략할 경우 같은 패키지에서만 사용 가능 
		int result = value>=0? value : -value;
		return result;
	}//절대값
}
