//Ex05 변경하기
package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

//오늘 생일인 친구들 출력
public class Ex08_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-14", "서울 서대문"),
							 new Friend("김길동", "010-9999-3333", "12-14", "수원 영통"),
							 new Friend("김수환", "010-9999-1111", "02-17", "서울 용산"),
							 new Friend("거북이", "010-6666-6666", "12-24", "인천 송도")};
		GregorianCalendar now = new GregorianCalendar();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
		String today = sdf1.format(now.getTime());
		boolean none = true;
		System.out.println("오늘 생일인 친구 목록을 검색합니다");
		for(Friend friend : friends) {
			if(today.equals(friend.getBirth())) {
				System.out.println(friend);
				none = false;
			}
		}//for
//		for(int idx=0 ; idx<friends.length ; idx++) {
//			String birth = friends[idx].getBirth();
//			if(today.equals(birth)) {
//				System.out.println(friends[idx]);
//				none = false;         //한명 이상 출력 시 none = false
//			}//if
//		}//for
		if(none) {
			System.out.println("오늘 생일인 친구가 없습니다");
		}
	}//main
}//class
