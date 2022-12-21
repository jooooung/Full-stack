package com.lec.quiz;

public class Customer {
	private String name;
	private String tel;
	private String address;

	public Customer(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		return "[이름] " + getName() + "\t[전화번호] " + getTel() + "\t[주소] " + getAddress();
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Customer other = (Customer) obj;
			boolean nameChk = name == other.name;
			boolean telChk = tel == other.tel;
			boolean addressChk = address == other.address;
			return nameChk && telChk && addressChk;
		} else {
			return false;
		}
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
