package com.lec.quiz;

public class Customer {
	private String name;
	private String tel;
	private String address;

	public Customer() {
		super();
	}

	public Customer(String name, String tel, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	@Override
	public String toString() {
		return "회원 정보 - 이름 =" + name + ", 전화번호=" + tel + ", 주소=" + address;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj !=null & getClass() == obj.getClass()) {
			Customer other = (Customer) obj;
			return tel == other.tel && name.equals(other.name) && address.equals(other.address);
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
