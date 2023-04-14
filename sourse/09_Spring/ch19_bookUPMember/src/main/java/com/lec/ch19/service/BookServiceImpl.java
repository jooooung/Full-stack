package com.lec.ch19.service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum) {
		Paging paging = new Paging(bookDao.totCntBook(), pageNum, 3, 3);
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.bookList(book);
	}

	@Override
	public int totCntBook() {
		return bookDao.totCntBook();
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(Book book, MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		String backupPath = "C:/Full-stack/sourse/09_Spring/ch19_bookUPMember/src/main/webapp/bookImgFileUpload/";
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = {"", ""};
		int i = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			bimg[i] = mFile.getOriginalFilename();
			if(bimg[i] != null && !bimg[i].equals("")) {
				// 파일 첨부 함
				if(new File(uploadPath+bimg[i]).exists()) {
					// 서버에 동일 파일명 있을 시 파일명 교체
					bimg[i] = System.currentTimeMillis() + bimg[i];
				}
				try {
					mFile.transferTo(new File(uploadPath+bimg[i]));
				    System.out.println("서버파일 : "+uploadPath+bimg[i]);
				    System.out.println("백업파일 : "+backupPath+bimg[i]);
				    int result = fileCopy(uploadPath + bimg[i], backupPath + bimg[i]);	// 파일카피
				    System.out.println(result == 1? i + "번째 백업 성공" : i + "번째 백업 실패");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int modifyBook(int bnum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
