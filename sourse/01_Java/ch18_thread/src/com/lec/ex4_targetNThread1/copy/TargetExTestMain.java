package com.lec.ex4_targetNThread1.copy;
// target 객체는 N개, 쓰레드는 1개 = 
public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable targetA = new TargetEx(); //run()함수에 A면 num 증가, A가 아니면 num-0
		Runnable targetB = new TargetEx();
		Thread threadA = new Thread(targetA, "A");
		Thread threadB = new Thread(targetB, "B");
		threadA.start();
		threadB.start();
		System.out.println("메인 함수 끝");
	}
}
