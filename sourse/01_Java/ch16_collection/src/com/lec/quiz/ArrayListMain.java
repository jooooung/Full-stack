package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		String answer;

		do {
			System.out.print("회원 등록하시겠습니까?(Y, N) ");
			answer = scanner.next();
			// N를 누른 경우
			if (answer.equalsIgnoreCase("N")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (answer.equalsIgnoreCase("Y")) {

				// 방법 1:
				Customer newcustomer = new Customer();
				System.out.print("이름을 입력하세요: ");
				newcustomer.setName(scanner.next());
				System.out.print("전화번호를 입력하세요: ");
				newcustomer.setTel(scanner.next());
				System.out.print("주소를 입력하세요: ");
				scanner.nextLine(); // 버퍼를 지우는 용도
				newcustomer.setAddress(scanner.nextLine());
				customers.add(newcustomer);
				System.out.println(newcustomer.getName() + "님 환영합니다.\n");

				// 방법 2:
//				System.out.print("이름을 입력하세요: ");
//				String name = scanner.next();
//				System.out.print("전화번호를 입력하세요: ");
//				String tel = scanner.next();
//				System.out.print("주소를 입력하세요: ");
//				scanner.nextLine(); // 버퍼를 지우는 용도
//				String add = scanner.nextLine();
//				customers.add(new Customer(name, tel, add));
//				System.out.println(name + "님 환영합니다.\n");
			}
		} while (true);
		scanner.close();

		if (customers.isEmpty()) {
			System.out.println("등록된 회원 목록이 없습니다.");
		} else {
			System.out.println("\n----- 회원 목록 -----");
			for (Customer customer : customers) {
				System.out.println(customer);
			}
		}
	}

}
