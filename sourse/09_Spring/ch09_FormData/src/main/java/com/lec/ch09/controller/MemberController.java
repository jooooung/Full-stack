package com.lec.ch09.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.style.DefaultValueStyler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch09.vo.MemberDto;

@Controller
@RequestMapping("member")	// 공통 요청 경로
public class MemberController {
	// 모든 요청 경로의 jsp 페이지에 출력할 것
	@ModelAttribute("cnt")	// ex) 장바구니 상품 개수
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")	// ex) 장바구니 물건 리스트
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;
	}
	
	@RequestMapping(value="join1", method = RequestMethod.GET)
	public String join1(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	
	@RequestMapping(value="join2", method = RequestMethod.GET)
	public String join2(@RequestParam("name") String memberName,
			@RequestParam("id") String memberId,
			@RequestParam("pw") String memberPw,
			@RequestParam("age") int memberAge,
			@RequestParam("email") String memberEmail,
			@RequestParam("address") String memberAddress, Model model) {
		model.addAttribute("name", memberName);
		model.addAttribute("id", memberId);
		model.addAttribute("pw", memberPw);
		model.addAttribute("age", memberAge);
		model.addAttribute("email", memberEmail);
		model.addAttribute("address", memberAddress);
		return "member/result1";
	}
	
	@RequestMapping(value="join3", method = RequestMethod.GET)
	public String join3(String name, String id, String pw, int age, 
						String email, String address, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	
//	@RequestMapping(value="join4", method = RequestMethod.GET)
//	public String join4(String name, String id, String pw, int age, 
//						String email, String address, Model model) {
//		MemberDto member = new MemberDto();
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setAge(age);
//		member.setEmail(email);
//		member.setAddress(address);
//		model.addAttribute("member", member);
//		return "member/result4";
//	}
	@RequestMapping(value="join4", method = RequestMethod.GET)
	public String join4(MemberDto memberDto, Model model) { 
				// MemberDto memberDto 이렇게 쓰려면 매개변수 없는 생성자, setter 필요
		model.addAttribute("member", memberDto);
		return "member/result4";
	}
	
	@RequestMapping("join5")
	public String join5(MemberDto memberDto) { // class 이름과 변수 이름은(첫글자 소문자로 변경)같아야한다
		return "member/result5";
	}
	
	@RequestMapping("join6")
	public String join6(@ModelAttribute("member") MemberDto memberDto) {
		return "member/result4";
	}
}
