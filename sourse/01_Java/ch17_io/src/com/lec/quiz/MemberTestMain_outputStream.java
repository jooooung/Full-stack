package com.lec.quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Member> member = new ArrayList<>();
		Writer writer = null;
		try {
			writer = new FileWriter("com\\lec\\quiz\\MemberTestMain_outputStream.txt", true);
			do {
				System.out.print("회원가입을 하시겠습니까? (y/n)");
				if (scanner.next().trim().equals("x"))
					break;
				System.out.print("이름");
				name = scanner.next();
				System.out.print("전화번호(010-0000-0000)");
				String tel = scanner.next();
				System.out.print("생일 (yyyy-MM-dd)");
				String birthday = scanner.next();
				System.out.print("주소 (구까지)");
				String address = scanner.next();
			} while();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
/*
ArrayList : 회원 
Date : 오늘 생일인 회원이 있는지 확인
today : 오늘 변수

*/