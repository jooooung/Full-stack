//name, tel, infoString
package com.lec.ex09_customer;

public class Staff extends Person {
	private String hiredate; // 입사일 ("2000-12-12")
	private String deparment; // 부서
	// Staff s = new Staff("홍사원", "010-8888-8888", "2022-12-01", "전산실")

	public Staff(String name, String tel, String hiredate, String deparment) {
		super(name, tel);
		this.hiredate = hiredate;
		this.deparment = deparment;
	}
	@Override
	public String infoString() {
		return super.infoString() + "   [부서]" + deparment + "   [입사일]" + hiredate;
	}
}
