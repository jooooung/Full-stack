package com.lec.ch11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.service.*;

@Controller
@RequestMapping("mvcBoard")	// 공통요청경로
public class MvcBoardController {
	private Service bservice;
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) { // service에 전달해야하니 Model 생성
		// mvcBoard/list.do
		// mvcBoard/list.do?pageNum=10
		model.addAttribute("pageNum", pageNum);
		bservice = new BListService();
		bservice.execute(model);
		return "mvcBoard/list";
	}
}
