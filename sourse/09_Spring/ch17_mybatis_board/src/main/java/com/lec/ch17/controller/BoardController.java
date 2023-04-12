package com.lec.ch17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.utill.Paging;
import com.lec.ch17.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) {
		model.addAttribute("list", boardService.list(pageNum));
		model.addAttribute("paging", new Paging(boardService.totCnt(), pageNum, 10, 10));
		return "board/list";
	}
	
}
