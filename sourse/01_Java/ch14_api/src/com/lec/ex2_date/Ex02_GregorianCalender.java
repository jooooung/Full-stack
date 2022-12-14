package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_GregorianCalender {
	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar();
//		Calendar now =Calendar.getInstance();
//		System.out.println(now);
		// 2022년 12월 14일 수요일 09시48분
		int year = now.get(Calendar.YEAR);     //YEAR = static field   get에 1을 넣으면 알아서 year로 반환
		int month = now.get(Calendar.MONTH) + 1;   //MONTH = static final    시스템 상 0월부터 시작하기에 +1
		int day = now.get(Calendar.DAY_OF_MONTH);  
		int week = now.get(Calendar.DAY_OF_WEEK);  //1:일 2:월 3:화 ... 7:토
		int hour24 = now.get(Calendar.HOUR_OF_DAY);  // 24시간 
		int hour = now.get(Calendar.HOUR);   // 12시간  (오전, 오후 나눠줘야함)
		int ampm = now.get(Calendar.AM_PM);  //0:오전  1:오후
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int milliSec = now.get(Calendar.MILLISECOND);
		System.out.printf("%d년 %d월 %d일", year, month, day);
		switch(week) {
		case 1: System.out.print("일요일"); break;
		case 2: System.out.print("월요일"); break;
		case 3: System.out.print("화요일"); break;
		case 4: System.out.print("수요일"); break;
		case 5: System.out.print("목요일"); break;
		case 6: System.out.print("금요일"); break;
		case 7: System.out.print("토요일"); break;
		}
		System.out.printf("\t%d시 %d분 %d초" + ("  %s %d시 %d분 %d초\n"), hour24, minute, second,
						(ampm == 0 ? "오전" : "오후"), hour, minute, second);
		//%d(정수)
		// %td(년) %tm(월) %td(일) %ta(요일) %tp(오전/오후) %tl(12시간) %tM(분) %tS(초)
		System.out.printf("%1$td년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초(%1$tp %1$tl시)\n", now);
	}
}
