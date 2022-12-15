package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true);  //timer 객체 만들기, 프로그램 종료 시 timer가 메모리에 상주 X 
		//true를 안 넣으면 프로그램 종료 시 timer가 메모리에 상주
		TimerTask task1 = new TimerTaskEx1();  //2초 후 한 번 실행
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000);  //2000은 밀리세컨 (2초) 2초 후 한번 task1.run() 수행
		timer.schedule(task2, 1000, 500);  //1초후에 0.5초마다 task2.run()수행
		Thread.sleep(11000);  //11초 후에 복귀
		System.out.println("끝");
	}
}
