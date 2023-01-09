package com.lec.ex3_supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner sc = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDto> customers;
		do {
			System.out.print("1:회원가입  2:번호뒷자리(Full)검색  3:물품구매  4:등급별출력  5:전체출력  6:탈퇴   그 외:종료  ->");
			fn = sc.next();
			switch (fn) {
			case "1":
				System.out.println("전화번호 : ");
				String ctel = sc.next();
				System.out.println("이름 : ");
				String cname = sc.next();
				int result = dao.insertCustomer(ctel, cname);
				System.out.println(result == CustomerDao.SUCCESS ? cname + "님 회원가입 완료. 포인트 1000" : "회원가입 실패");
				break;
			case "2":
				System.out.println("검색할 전화번호나 뒷자리는? ");
				String searchTel = sc.next();
				customers = dao.ctelGetCustomers(searchTel);
				if (customers.isEmpty()) {
					System.out.println("해당 번호의 고객이 없습니다");
				} else {
					System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3":
				System.out.println("고객아이디 : ");
				int cid = sc.nextInt();
				System.out.println("구매가격 : ");
				int price = sc.nextInt();
				result = dao.buy(cid, price);
				if (result == CustomerDao.SUCCESS) {
					System.out.println("구매 감사합니다");
					CustomerDto customer = dao.getCustomer(cid);
					System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
					System.out.println(customer);
				} else {
					System.out.println(cid + "는 유효한 고객 아이디가 아닙니다");
				}
				break;
			case "4":
				System.out.println("검색할 등급 : " + dao.getLevelNames());
				String levelName = sc.next();
				customers = dao.levelNameGetCustomers(levelName);
				if (customers.isEmpty()) {
					System.out.println("검색된 고객이 없습니다");
				} else {
					System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "5":
				customers = dao.getCustomers();
				if (customers.isEmpty()) {
					System.out.println("검색된 고객이 없습니다");
				} else {
					System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "6":
				System.out.print("탈퇴할 고객 전화번호 : ");
				ctel = sc.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDao.SUCCESS ? "탈퇴 완료" : "유효한 전화번호가 아닙니바");
				break;
			}

		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4") || fn.equals("5")
				|| fn.equals("6"));
		System.out.println("BYE");
	}
}
