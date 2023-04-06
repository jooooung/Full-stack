package com.lec.ch09.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
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
	
	@RequestMapping("/")
	public String input() {
		return "member/input";
	}
	
//	@RequestMapping(value="studentId/{id}")
//	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		String uri = request.getRequestURI(); // uri 가져와 맨 뒤의 아이디만 빼기
//		String id = uri.substring(uri.lastIndexOf("/") + 1);
//		// 인코딩된 id 디코딩
//		id = URLDecoder.decode(id, "utf-8");
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	@RequestMapping(value="studentId/{id}")
	public String studentId(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		return "studentId";
	}
}

