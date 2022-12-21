package com.lec.ex02_map;

import java.util.HashMap;
import java.util.Scanner;

import com.lec.ex01_list.Friend;

public class Ex03_FriendHashSearchTell {

	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<>();
		
		friends.put("1111", new Friend("김길동", "010-1111-1111"));
		friends.put("2222", new Friend("김길동", "010-2222-2222"));
		friends.put("3333", new Friend("김길동", "010-3333-3333"));
		friends.put("4444", new Friend("김길동", "010-4444-4444"));
		friends.put("5555", new Friend("김길동", "010-5555-5555"));
		
//		Iterator<String> iterator = friends.keySet().iterator();
//		while (iterator.hasNext()) {
//			String key = (String) iterator.next();
//			System.out.println(key + ": " + friends.get(key));
//		}
		
		// 전화번호 뒷자리 입력하여 검색
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("검색할 전화번호를 입력하세요: ");
			String searchTel = scanner.next();
			
			if (searchTel.equalsIgnoreCase("x")) {
				break;
			}
			
			if (friends.get(searchTel) != null) {
				System.out.println("검색결과: " + friends.get(searchTel));
			} else {
				System.out.println("검색한 결과가 없습니다.");
			}
		}
		scanner.close();
		
		
	}

}
