package com.lec.ch08.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch08.dto.Member;

// "board/write", "board/content", "board/list", "board/reply"
@Controller
@RequestMapping("board") // 공통 요청 경로
public class BoardController {
	@RequestMapping("write")
	public String write() {
		return "board/write";	// view : "WEB-INF/views/board/write.jsp
	}
	@RequestMapping("content")	// 조합된 요청경로 : /board/content
	public String content(Model model) {
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "111");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member);
		return "board/content";
	}
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();	// 빈 ModelAndView 객체 생성
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("aaa", "111"));
		list.add(new Member("bbb", "222"));
		mav.addObject("list", list);	// 객체에 추가
		mav.setViewName("board/list");	// 객체에 view 지정
		return mav;		// view 리턴
	}
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(ModelAndView mav) {
		Member member = new Member("ccc", "111");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;
	}
}
