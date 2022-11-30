package com.lec.loop;
//콘솔창에 다음과 같이 출력되도록 for문을 이용하여 구현하여 보자
//*
//**
//***
//****
//*****
public class Ex03_for_star {
	public static void main(String[] args) {
		for(int i=1 ; i<=5 ; i++) {
			for(int j=1 ; j<=i; j++) {
				System.out.print('*');
			}//for-j
				System.out.println();   //개행만 하는 역할
		}//for-i
	}//main
}//class