package com.lec.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// "member?method=join", "member?method=login", 
// "member?method=logout", "member?method=infoModify"
@Controller
@RequestMapping("member") // 공통 요청 경로
public class MemberController {
	@RequestMapping(params = "method=join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("kind", "회원");
		return "member/join";
	}
	
	@RequestMapping(params = "method=login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("result", "login");
		return "member/result";
	}
	
	@RequestMapping(params = "method=logout", method = RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("result", "logout");
		return "member/result";
	}
	
	// POST 방식
	@RequestMapping(params = "method=infoModify", method = RequestMethod.POST)
	public String infoModify(Model model) {
		model.addAttribute("result", "infoModify");
		return "member/result";
	}
	
	// GET 방식
	@RequestMapping(params = "method=infoModify", method = RequestMethod.GET)
	public ModelAndView infoModify(ModelAndView mav) {
		mav.addObject("result", "infoModify");
		mav.setViewName("member/result");
		return mav;
	}
	// GET = view.do, POST = .do라고 생각하면 된다
}


