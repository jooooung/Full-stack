package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
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
	String backupPath = "C:/Full-stack/sourse/09_Spring/ch19_bookUPMember/src/main/webapp/bookImgFileUpload/";
	
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
					System.out.println(e.getMessage());
				}
			} else {
				// 첨부 안 함
				System.out.println(i + "번째 첨부 안함 : " + bimg[i].equals("") != null ? "빈스트링" : "빈스트링 아님");
			} // if
			i++;
		} // while
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.registerBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
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
					System.out.println(e.getMessage());
				}
			} else {
				// 첨부 안 함
				System.out.println(i + "번째 첨부 안함 : " + bimg[i].equals("") != null ? "빈스트링" : "빈스트링 아님");
			} // if
			i++;
		} // while
		Book book = new Book();
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBinfo(mRequest.getParameter("binfo"));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.modifyBook(mRequest);
	}
	
	private int fileCopy(String serverFile, String backupFile) {
		int isCopy = 0;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = 1;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}
