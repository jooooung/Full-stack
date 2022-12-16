//두 시점 계산
package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex03_term {
	public static void main(String[] args) {
		Date now = new Date();  //지금
		Date checkOut = new Date(new GregorianCalendar(2022, 10, 28).getTimeInMillis());  //대출시점 
		long nowMillis = now.getTime();    // 1970.1.1 ~ now까지의 밀리세컨
		long checkMillis = checkOut.getTime(); //1970. 1. 1 ~ checkOut 까지의 밀리세컨
		
//		GregorianCalendar now = new GregorianCalendar();  // 현재
//		long nowMillis =now.getTimeInMillis();   //now.getTimeInMillis()는 1970년 1월 1일 부터 now 까지의 밀리세컨
//		GregorianCalendar checkOut = new GregorianCalendar(2022, 10, 28, 9, 30);  // 대출시점
//		long checkMillis = checkOut.getTimeInMillis(); //checkOut.getTimeInMillis(); 는   1970년 1월 1일 부터 checkOut 까지의 밀리세컨
		
		int day = (int)((nowMillis - checkMillis)/(1000*60*60*24));    //(1000*60*60*24)  밀리세컨->초->분->일   
//		//nowMillis, checkMillis 는 8byte 이기에 int로 형변환
		System.out.println("몇일 지났나 : " + day);
	}
}


//(now - checkOut) 계산이 안 되어 -> 1970년 1월 1일 부터 now 까지의 밀리세컨 - 1970년 1월 1일 부터 check 까지의 밀리세컨으로 계산