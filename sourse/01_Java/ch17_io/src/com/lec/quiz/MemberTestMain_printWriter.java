package com.lec.quiz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_printWriter {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		Scanner scanner = new Scanner(System.in);
		String today = sdf.format(now);
		String name, tel, birthStr, address;
		int year, month, day;
		Date birthday = null;

		do {
			System.out.print("회원가입을 하시겠습니까? (y/n)");
			if (scanner.next().equalsIgnoreCase("n"))
				break;
			System.out.print("이름");
			name = scanner.next();
			System.out.print("전화번호(010-0000-0000)");
			tel = scanner.next();
			System.out.print("생일 (yyyy-MM-dd)");
			birthStr = scanner.next();
			StringTokenizer token = new StringTokenizer(birthStr, "-");
			if (token.countTokens() == 3) {
				year = Integer.parseInt(token.nextToken());
				month = Integer.parseInt(token.nextToken());
				day = Integer.parseInt(token.nextToken());
				birthday = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
				birthStr = birthStr.substring(birthStr.indexOf("-") + 1);
				if (birthStr.equals(today)) {
					System.out.println(name + "님 생일 축하드립니다");
				}
			} else {
				System.out.println("생일 형식이 다릅니다");
			}
			System.out.print("주소 (구까지)");
			scanner.nextLine();
			address = scanner.nextLine();
			members.add(new Member(name, tel, birthday, address));
			System.out.println("회원가입 완료");
		} while (true);
		scanner.close();

		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter("src/com/lec/quiz/member.txt");
			for (Member member : members) {
				System.out.print(member);
				printWriter.write(member.toString());
			}
			String msg = String.format("\t\t\t... 이하 %d명 가입\n", members.size());
			System.out.println(msg);
			printWriter.write(msg);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (printWriter != null)
					printWriter.close();
			} catch (Exception ignore) {
				System.out.println(ignore.getMessage());
			}
		}
	}
}
