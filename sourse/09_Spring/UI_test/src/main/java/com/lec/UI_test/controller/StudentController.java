package com.lec.UI_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.UI_test.vo.Student;

@Controller
public class StudentController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	
	@RequestMapping(value="input.do", method = RequestMethod.GET)
	public String input(Student student) {
		return "student/input";
	}
	
	@RequestMapping(value="input.do", method = RequestMethod.POST)
	public String result(Student student) {
		return "student/result";
	}
}
