//<예제 전화번호 뒷자리로 검색하고 있으면 전화번호 전체를 출력하기, 없는 번호이면 없는 번호라고 출력하기>
package com.lec.ex1_string;

import java.util.Scanner;

public class Ex07_searchPostTelQuiz {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-8888", "010-6666-8888"};
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;    //검색한 결과가 있으면 true
			System.out.print("검색하고자 하는 전화번호 뒷자리는 ?(종료는 x)");
			String searchTel = scanner.next();
			if(searchTel.equalsIgnoreCase("x"))
				break;
			for(int i=0 ; i<tels.length ; i++) {
	//			int idx = tels[i].lastIndexOf("-");
	//			String postTel = tels[0].substring(idx+1;)
	//					System.out.println(i+"번째 뒷자리 : " + postTel);
				String postTel = tels[i].substring(tels[i].lastIndexOf("-")+1);
				if(postTel.equals(searchTel)) {
					System.out.println("검색하신 전화번호는 " + tels[i]);
					searchOk = true; // 전화번호 출력여부
				}//if
			}//for
			if(! searchOk) {
				System.out.println("검색하신 전화번호 뒷자리는 없습니다");
			}//if
		}//while
	}///main
}//class
