package com.lec.prac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.prac.dto.Board;
import com.lec.prac.service.BoardService;
import com.lec.prac.utill.Paging;


@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	
	// 글목록
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		model.addAttribute("list", boardService.list(pageNum));
		model.addAttribute("paging", new Paging(boardService.totCnt(), pageNum, 10, 10));
		return "board/list";
	}
	
	// 상세보기
	@RequestMapping(value = "detail", method = {RequestMethod.GET, RequestMethod.POST})
	public String detail(int bid, String pageNum, Model model) {
		model.addAttribute("boardDto", boardService.detail(bid));
		return "board/detail";
	}
	
	// 글쓰기 페이지
	@RequestMapping(value = "writeView", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Board board, Model model) {
		return "board/write";
	}
	
	// 쓴 글 저장
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("writeResult", boardService.write(board, request));
		return "forward:list.do";
	}
	
	// 글수정
	@RequestMapping(value = "modifyView", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyView(int bid, Model model) {
		model.addAttribute("board", boardService.detail(bid));
		return "board/modify";
	}
	
	// 수정글 저장
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("modifyResult", boardService.modify(board, request));
		return "forward:detail.do";
	}
	
	// 답글 쓰기 페이지
	@RequestMapping(value = "replyView", method = RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("boardDto", boardService.detail(bid));
		return "board/reply";
	}
	
	// 답글 저장
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("BoardDto", boardService.reply(board, request));
		return "forward:list.do";
	}
	
	// 글삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("delete", boardService.delete(bid));
		return "forward:list.do";
	}
}
