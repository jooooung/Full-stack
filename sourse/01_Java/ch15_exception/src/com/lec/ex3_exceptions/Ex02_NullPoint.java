package com.lec.ex3_exceptions;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex02_NullPoint {
	public static void main(String[] args) {
		Friend hong = new Friend("È«±æµ¿", "010-9999-8888", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis()));
		System.out.println(hong);
		Friend kim = new Friend("±è±æµ¿", "010-4444-5555");
		System.out.println(kim);
	}
}
