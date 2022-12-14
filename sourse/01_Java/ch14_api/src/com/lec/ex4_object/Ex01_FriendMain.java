package com.lec.ex4_object;

public class Ex01_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-14", "서울 서대문"),
				new Friend("김길동", "010-9999-3333", "12-26", "수원 영통"),
				new Friend("김수환", "010-9999-1111", "02-17", "서울 용산"),
	 			new Friend("거북이", "010-6666-6666", "03-03", "인천 송도") };
		for(Friend friend : friends) {
			System.out.println(friend.toString());   //friend class
			
		}
	}
}
