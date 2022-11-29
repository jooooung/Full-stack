package com.lec.java;
// 형변환 
public class VarEx06 {
	public static void main(String[] args) {
		int i =10;
		double d = i;  
		// d = 10.0 묵시적인 형변환(할당하려는 값이 할당량보다 작을 시)
		// 절대 데이터 손실이 일어나지 않음
		i = (int)10.6; //명시적인 형변환 (데이터 손실 o)
		//int에 10.6이 들어가지 않기에 명시적 형변환
		
	}
}
