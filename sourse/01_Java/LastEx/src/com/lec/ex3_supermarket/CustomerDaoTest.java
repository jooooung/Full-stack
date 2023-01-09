package com.lec.ex3_supermarket;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> Customers;
		System.out.println("----------1. 회원가입 --------");
		String ctel = "010-1111-1111", cname="이순신";
		result = dao.insertCustomer(ctel, cname);
		System.out.println(result==CustomerDao.SUCCESS? cname+"님 회원가입 완료. 포인트 1000점":"cname님 회원가입 실패");
		System.out.println("----------2. 전화번호 검색 ----------");
		ctel = "3333";
		Customers = dao.ctelGetCustomers(ctel);
		if(Customers.isEmpty()) {
			System.out.println("전화번호가 없습니다");
		} else {
			System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
			for (CustomerDto customer : Customers) {
				System.out.println(customer);
			}
		}
		System.out.println("--------3. 물건구입-----------");
		result = dao.buy(1, 200000);
		if(result==CustomerDao.SUCCESS) {	// 구입 성공 시 성공메세지와 고객 정보 출력
			CustomerDto customer = dao.getCustomer(1);
			System.out.println("구입해주셔서 감사합니다");
			System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
			System.out.println(customer);
		} else {
			System.out.println("id를 잘못 입력하였습니다");
		}
		System.out.println("-----------4. 등급별 고객----------------");
		System.out.println("등급 : " + dao.getLevelNames());
		Customers = dao.levelNameGetCustomers("VVIP");
		if(Customers.size()==0) {
			System.out.println("이 등급의 고객이 없습니다");
		} else {
			System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
			for (CustomerDto customer : Customers) {
				System.out.println(customer);
			}
		} 
		System.out.println("--------- 5. 전체출력---------");
		Customers = dao.getCustomers();
		if(Customers.size()==0) {
			System.out.println("이 등급의 고객이 없습니다");
		} else {
			System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
			for (CustomerDto customer : Customers) {
				System.out.println(customer);
			}
		}
		System.out.println("---------- 6. 회원탈퇴----------");
		result = dao.deleteCustomer("010-1234-1234");
		System.out.println(result==CustomerDao.SUCCESS? "삭제성공":"유효한 전화번호가 아닙니다");
		
		System.out.println("아이디\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업필요금액");
		for (CustomerDto customer : Customers) {
		System.out.println(customer);
		}
	}
}

