package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex05_FriendArrayList2 {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-9999-9999"));
		friends.add(new Friend("이길동", "010-1111-9999", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis())));
		friends.add(new Friend("마길동", "02-222-9999"));
		for (int i=0 ; i<friends.size() ; i++) {
			System.out.println(friends.get(i));
		}
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색하고자 하는 전화번호 뒷자리(종료 : x)");
			String searchTel = sc.next();
			if (searchTel.equalsIgnoreCase("x")) 
				break;
			for(Friend friend : friends) {
				String tel = friend.getTel();
				String postTel = tel.substring(tel.lastIndexOf("-")+1);
				if(searchTel.equals(postTel)) {
					System.out.println(friend);
					searchOk = true;
				}
			}//for
			if(! searchOk) {
				System.out.println("검색하신 전화번호 뒷자리는 없습니다");
			}
		}
	}
}
