package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import com.lec.ex4_object.Friend;

//오늘 생일인 친구들 출력
public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-14", "서울 서대문"),
							 new Friend("김길동", "010-9999-3333", "12-26", "수원 영통"),
							 new Friend("김수환", "010-9999-1111", "02-17", "서울 용산"),
							 new Friend("거북이", "010-6666-6666", "03-03", "인천 송도")};
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) + 1;  // 시스템상 월이 0부터 시작하기에 +1을 해준다
		int day = now.get(Calendar.DAY_OF_MONTH);
		String monthStr = month<10 ? "0"+month : ""+month;   //빈 스트링을 더해서 month를 int에서 string 으로 형변환
		String dayStr = day<10 ? "0"+day : ""+day;
		String today = monthStr + "-" + dayStr;
		System.out.println(today);
		boolean none = true;
		System.out.println("오늘 생일인 친구 목록을 검색합니다");
		for(int idx=0 ; idx<friends.length ; idx++) {
			String birth = friends[idx].getBirth();
			if(today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false;         //한명 이상 출력 시 none = false
			}//if
		}//for
		if(none) {
			System.out.println("오늘 생일인 친구가 없습니다");
		}
	}//main
}//class
