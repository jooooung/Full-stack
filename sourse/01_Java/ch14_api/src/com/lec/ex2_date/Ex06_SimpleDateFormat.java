package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex06_SimpleDateFormat {
	public static void main(String[] args) {
		Date nowDate = new Date();
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar nowGc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) a hh시 m분");
		System.out.println(sdf.format(nowDate));
		String dateStr = sdf.format(nowDate);
		String calStr = sdf.format(nowCal.getTime());    
		//nowCal을 넣으면 format에 Date형만 와야되기에 nowCal.getTime()이용하여 Calendar를 Date형으로 변환
		String gcStr = sdf.format(nowGc.getTime());
		System.out.println(dateStr);
		System.out.println(calStr);
		System.out.println(gcStr);
	}
}

/* yyyy(년도 4자리), yy(년도 2자리), MM(월,02), M(월, 2), dd(일 07), d(일 7)
	E(요일), a(오전/오후), H(24시), h(12시). m(분), s(초)
	w(이번년도의 몇번째 주인지) W(이번 월에 몇번째 주인지) D(올해의 몇번째 날) */