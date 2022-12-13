//String, StringBuffer, StringBuilder 속도 비교하기
package com.lec.ex1_string;

public class Ex10_StringSpeedCheck {
	public static void main(String[] args) {
		System.out.println("1970.1.1부터 현재까지의 밀리세컨 : " + System.currentTimeMillis());
		String str = "a";
		long start = System.currentTimeMillis(); // 시작 시점의 밀리세컨
		// String 변수 10만번 변경하기
		for (int i = 0; i < 100000; i++) {
			// String 변수 변경
			str = str.concat("b");
		}
		long end = System.currentTimeMillis();
		System.out.println("스트링 10만번 변경 경과 시간 : " + (end - start));
		StringBuffer strBuf = new StringBuffer("a");
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			strBuf.append("b");
		}
		end = System.currentTimeMillis();
		System.out.println("스트링버퍼 10만번 변경 경과 시간 : " + (end - start));
		StringBuilder strBil = new StringBuilder("a");
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			strBil.append("b");
		}
		end = System.currentTimeMillis();
		System.out.println("스트링버퍼 10만번 변경 경과 시간 : " + (end - start));
	}
}
