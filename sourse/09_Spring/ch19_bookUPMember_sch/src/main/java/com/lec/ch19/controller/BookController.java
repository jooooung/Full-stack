package com.lec.ch19.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	// 도서 목록
	@RequestMapping(params = "method=list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model, Book book) {
		model.addAttribute("paging", new Paging(bookService.totCntBook(book), pageNum, 3, 3));
		model.addAttribute("bookList", bookService.bookList(pageNum, book));
		return "book/list";
	}
	
	// 도서 상세보기
	@RequestMapping(params = "method=detail", method = RequestMethod.GET)
	public String detail(int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/detail";
	}
	
	// 도서 등록 페이지
	@RequestMapping(params = "method=register", method = RequestMethod.GET)
	public String register() {
		return "book/register";
	}
	// 도서 등록 DB 저장
	@RequestMapping(params = "method=register", method = RequestMethod.POST)
	public String register_post(Book book, Model model, MultipartHttpServletRequest mRequest) {
		model.addAttribute("registerResult", bookService.registerBook(book, mRequest));
		return "book/register";
	}
	
	// 도서 수정하기 페이지
	@RequestMapping(params = "method=modify", method = RequestMethod.GET)
	public String modify(int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/modify";
	}
	// 도서 수정 DB 저장
	@RequestMapping(params = "method=modify", method = RequestMethod.POST)
	public String modify_post(Book book, Model model, MultipartHttpServletRequest mRequest, String pageNum) {
		int modifyResult = bookService.modifyBook(book, mRequest);
		return "redirect:book.do?method=list&pageNum="+pageNum+"&modifyResult="+modifyResult;
	}
}
