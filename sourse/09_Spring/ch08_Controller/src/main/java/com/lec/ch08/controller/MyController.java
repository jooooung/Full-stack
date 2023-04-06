package com.lec.ch08.controller;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	// localhost 의 요청처리 로직
	@RequestMapping("/")
	public String home() {
//		request.setAttribute("greeting", "안녕 스프링") -> ${greeting}
//		model.addAttribute("greeting", "안녕 스프링"	);
		return "main";	// view : "/WEB-INF/views/" + "main" + ".jsp"
	}
}
