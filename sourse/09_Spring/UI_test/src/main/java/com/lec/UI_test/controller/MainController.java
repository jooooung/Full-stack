package com.lec.UI_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	
	@RequestMapping("/")
	public String input() {
		return "student/input";
	}
}
