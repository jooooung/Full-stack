package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService ;
	
	// 회원가입 페이지
	@RequestMapping(params = "method=join", method = RequestMethod.GET)
	public String join() {
		return "member/join";	
	}
	// id 중복확인 (member.do?method=idConfirm&mid=aaa)
	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("idConfirmResult", memberService.idConfirm(mid));
		return "member/idConfirm";
	}
	// 회원가입 완료		매개변수로 member를 넣으면 헤더가 로그인 한 것처럼 바뀌기에 mDto로 이름 변경
	@RequestMapping(params = "method=join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mDto") Member member, Model model, HttpSession session) {
		model.addAttribute("joinResult", memberService.joinMember(member, session)); 
		return "member/login";
	}
	
	// 로그인 페이지
	@RequestMapping(params = "method=login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	// 로그인
	@RequestMapping(params = "method=login", method = RequestMethod.POST)
	public String login(String mid, String mpw, String after, HttpSession httpSession, Model model) {
		String loginResult = memberService.loginCheck(mid, mpw, httpSession);
		if(loginResult.equals("로그인 성공")) {
			return "redirect:" + after;
		}else {	// 로그인 실패
			model.addAttribute("loginResult", loginResult);
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			return "member/login";
		}
	}
	
	// 로그아웃
	@RequestMapping(params = "method=logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:main.do";
	}
	
	// 정보수정 페이지
	@RequestMapping(params = "method=modify", method = RequestMethod.GET)
	public String modify() {
		return "member/modify";
	}
	// 비로그인 시 정보수정 페이지로 갈 시 
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify1() {
		return "member/modify";
	}
	// 정보수정 저장
	@RequestMapping(params = "method=modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("mDto") Member member, Model model, HttpSession httpSession) {
		model.addAttribute("modifyResult", memberService.modifyMember(member, httpSession));
		return "forward:main.do";
	}
	// @RequestMapping(params = "", method = RequestMethod.)
	// @RequestMapping(params = "", method = RequestMethod.)
	// @RequestMapping(params = "", method = RequestMethod.)
}
