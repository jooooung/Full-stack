package com.lec.quiz02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {

	private String name;
	private String phone;
	private String address;
	private Date birthday;

	public Friend() {
	}
	
	public Friend(String name, String address, String phone, Date birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		String result;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		result = "이 름: " + getName() + "\n주 소: " + getAddress() + "\n핸드폰: " + getPhone() + "\n생 일: " + sdf.format(getBirthday()) + "\n";
		return result;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	
}
