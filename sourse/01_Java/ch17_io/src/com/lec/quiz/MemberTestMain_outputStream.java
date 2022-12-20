package com.lec.quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Date today = new Date();
		ArrayList<Member> member = new ArrayList<>();
		OutputStream os = null;
		do {
			System.out.print("회원가입을 하시겠습니까? (y/n)");
			String newMember = scanner.next().trim();
			if (newMember.equalsIgnoreCase("x"))
				break;
			System.out.print("이름");
			String name = scanner.next();
			System.out.print("전화번호(010-0000-0000)");
			String tel = scanner.next();
			System.out.print("생일 (yyyy-MM-dd)");
			String birthday = scanner.next();
			System.out.print("주소 (구까지)");
			String address = scanner.next();
			member.add(new Member(name, tel, birthday, address));
		} while();
		
	}
}
/*
 * ArrayList : 회원 Date : 오늘 생일인 회원이 있는지 확인 today : 오늘 변수
 * 
 */