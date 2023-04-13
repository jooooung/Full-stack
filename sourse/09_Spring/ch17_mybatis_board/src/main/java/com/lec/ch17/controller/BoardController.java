package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.dto.Board;
import com.lec.ch17.service.BoardService;
import com.lec.ch17.utill.Paging;

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
	
	// 글쓰기 페이지
	@RequestMapping(value = "writeView", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Model model, HttpServletRequest request) {
		model.addAttribute("bip", request.getRemoteAddr());
		return "board/write";
	}
	
	// 글쓰기 저장
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Board board, Model model) {
		model.addAttribute("writeResult", boardService.write(board));
		return "forward:list.do";
	}
	
	// 상세보기
	@RequestMapping(value = "detail", method = {RequestMethod.GET, RequestMethod.POST})
	public String detail(int bid, String pageNum, Model model) {
		boardService.hitUp(bid);
		model.addAttribute("boardDto", boardService.detail(bid));
		return "board/detail";
	}
	
	// 글 수정 페이지
	@RequestMapping(value = "modifyView", method = {RequestMethod.GET, RequestMethod.POST})	// 수정 페이지
	public String updateView(int bid, Model model, HttpServletRequest request) {
		model.addAttribute("bip", request.getRemoteAddr());
		model.addAttribute("board", boardService.detail(bid));
		return "board/modify";
	}
	// 수정 정보 저장
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String update(Board board, Model model) {
		try {
			model.addAttribute("modifyResult", boardService.modify(board));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("modifyResult", "필드 값이 너무 길어요");
			return "forward:modifyView.do";
		}	// 압력값 길게 칠 시 에러 처리
		return "forward:detail.do";		// 수정 후 상세보기 페이지
	}
	
	// 글 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.delete(bid));
		return "forward:list.do";
	}
	
	
}
