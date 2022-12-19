package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMain {
	private static String customer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> customer = new ArrayList<>();
		while (true) {
			System.out.println("회원가입을 진행하시겠습니까? (Y/N)");
			String newCus = sc.next();
			if (newCus.equalsIgnoreCase("N")) {
				if (customer.size() == 0) {
					System.out.println("회원이 없습니다");
				} else {
					for (Customer cus : customer) {
						System.out.println(cus);
					}
				}
				break;
			} else if (newCus.equalsIgnoreCase("Y")) {
				System.out.println("이름을 입력해주세요 ");
				String name = sc.next();
				System.out.println("전화번호를 입력해주세요");
				String tel = sc.next().trim();
				System.out.println("주소를 입력해 주세요(구까지)");
				sc.nextLine();
				String address = sc.nextLine().trim();
				customer.add(new Customer(name, tel, address));
				System.out.println("회원가입이 완료되었습니다");
			} else {
				System.out.println("잘못 입력했습니다");
			}
		}
	}
}
