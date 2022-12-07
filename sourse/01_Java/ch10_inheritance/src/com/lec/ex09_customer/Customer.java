package com.lec.ex09_customer;

import cons.Constant;

public class Customer extends Person {
	private String address;
	private int sum;  //구매금액 누적
	private int point; //포인트
	private String date;
	private boolean vip;
	// Customer c = new Customer("홍길동", "010-9999-9999", "서울", "12-12"
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name +"님 가입 감사합니다. 포인트 1000점 드렸습니다");
	}
	public void buy(int price) { //c.buy(2000)  산 물건의 금액
		sum += price;  //구매금액에 누적 
//		int tempPoint = (int)(price * 0.05);
		int tempPoint = (int)(price * Constant.RATE);  //구매금액의 포인트
		point += tempPoint;  // 포인트 누적
		System.out.println(getName()+"님 감사합니다. 포인트 :" + tempPoint);
		System.out.println("누적 포인트 : " + point);
		System.out.println("구매금액 : "+ price);
		if(vip == false && sum >= Constant.VIPLIMIT) { // vip 가 아닐 때 vip 금액에 만족한다면
			vip = true;
			System.out.println(getName() + "님 VIP 고객으로 업그레이드 되셨습니다");
		}//if
	}//buy
	@Override
	public String infoString() {
		return super.infoString() + "   [주소]"+address +"   [포인트]"+ point + "   [누적구매금액]" + sum + "   [vip여부]" + vip;
	}
}//Customer
