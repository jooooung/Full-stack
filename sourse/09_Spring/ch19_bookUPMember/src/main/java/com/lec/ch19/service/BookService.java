package com.lec.ch19.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;

public interface BookService {
	public List<Book> mainList();
	public List<Book> bookList(String pageNum);
	public int totCntBook();
	public Book getDetailBook(int bnum);
	public int registerBook(Book book, MultipartHttpServletRequest mRequest);
	public int modifyBook(MultipartHttpServletRequest mRequest);
}
