/*메소드 : “아이디 = aaa
                 이름 = 홍길동
                 이메일 = hong@company.com
                 주소 = 서울 강남구
                 생일 = 2000-01-01
                 성별 = 남 ”
*/
package com.lec.ex6_member;

public class Member {
	private String id;
	private String password;
	private String name;
	private String email;
	private String add;
	private String birth;
	private char gender;
	
	public Member() {}

	public Member(String id, String password, String name, String email, String add, String birth, char gender) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.add = add;
		this.birth = birth;
		this.gender = gender;
	}
	public void print() {
		System.out.println("id : " + id);
		System.out.println("이름 : " + name);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + add);
		System.out.println("생일 : " + birth);
		System.out.println("성별 : " + gender);
	}
	public String infoString() {
		String result = "id : " + id;
		result += "\n이름 : " + name;
		result += "\n이메일 : " + email;
		result += "\n주소 : " + add;		
		result += "\n생일 : " + birth;		
		result += "\n성별 : " + (gender == '남' ? "남자" : (gender == '여' ? "여자" : "무"));
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
