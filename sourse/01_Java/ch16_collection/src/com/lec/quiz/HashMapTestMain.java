package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapTestMain {
	public static void main(String[] args) {
		HashMap<String, Customer> customers = new HashMap<String, Customer>();

		Scanner scanner = new Scanner(System.in);
		String answer;
		String tel;

		do {
			System.out.print("회원 등록하시겠습니까?(Y, N) ");
			answer = scanner.next();
			if (answer.equalsIgnoreCase("N")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (answer.equalsIgnoreCase("Y")) {
				Customer newcustomer = new Customer();
				System.out.print("이름을 입력하세요: ");
				newcustomer.setName(scanner.next());
				System.out.print("전화번호를 입력하세요: ");
				tel = scanner.next();
				// 기존에 가입한 전화번호인지 확인
				if (customers.get(tel) != null) {
					System.out.println("이미 가입되어 있는 전화번호입니다. 전화번호는 중복하여 가입이 불가합니다.");
					continue;
				}
				newcustomer.setTel(tel);
				System.out.print("주소를 입력하세요: ");
				scanner.nextLine(); // 버퍼를 지우는 용도
				newcustomer.setAddress(scanner.nextLine());
				customers.put(tel, newcustomer);
				System.out.println(newcustomer.getName() + "님 환영합니다.\n");
			}

		} while (true);
		scanner.close();

		if (customers.isEmpty()) {
			System.out.println("등록된 회원 목록이 없습니다.");
		} else {
			System.out.println("\n----- 회원 목록 -----");
			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(customers.get(key));
			}
		}
	}

}
