package com.lec.ch10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
//	@RequestMapping(value = "student")
//	public String student(String id, Model model, HttpServletRequest request) {
//		String method = request.getMethod();	// get or post 확인
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	
	// get / post 분리하기
	@RequestMapping(value="student", method = RequestMethod.GET)
	public String student(String id, Model model) {
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";	
	}
	// 같은 메소드가 올 수 없으니 POST는 ModelAndView로 변경 
	@RequestMapping(value="student", method = RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView modelAndView) {
		modelAndView.addObject("method", "POST");
		modelAndView.addObject("id", id);
		modelAndView.setViewName("studentId");
		return modelAndView;	
	}
	
	// studentOk.do
	@RequestMapping(value = "studentOk", method = RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	
	//studentNg.do
	@RequestMapping(value = "studentNg", method = RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	@RequestMapping(value = "studentNg", method = RequestMethod.POST)
	public ModelAndView studentNg(ModelAndView mav) {
		mav.setViewName("studentNg");
		return mav;
	}
	
	// idConfirm.do
	@RequestMapping(value = "idConfirm", method = RequestMethod.POST)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			// 맞는 id 입력 -> "studentOk.do" 요청
			return "redirect:studentOk.do";  // studentOk.do를 GET방식으로 요청
		}else {
			// 틀린 id 입력 -> "studentNg.do" 요청
			return "forward:studentNg.do";  // studentNg.do를 idConfirm요청 방식과 같은 방식으로 요청
		}
	}
	
	@RequestMapping(value = "fullPath", method = RequestMethod.GET)
	public String fullPath() {
//		return "redirect:http://www.naver.com";
		return "redirect:http://localhost:8090/ch10/temp/fullPath.jsp";
	}
}
