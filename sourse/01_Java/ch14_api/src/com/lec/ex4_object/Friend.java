package com.lec.ex4_object;

public class Friend {
	private String name;
	private String tel;
	private String birth; // 년도 빼고 월 일 만 저장
	private String address;

	public Friend() {}
	public Friend(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
    @Override
    public String toString() {
    	return "[이름]"+name + "[전화번호]"+tel +"[생일]"+birth + "[주소]"+address;
    }
    
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public String getBirth() {
		return birth;
	}
}
