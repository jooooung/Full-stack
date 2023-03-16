package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.FileboardDao;
import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.FIleboardDto;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.org.apache.bcel.internal.generic.IFLE;

public class BoardWriteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fileBoardUp");
		int maxSize = 1024 * 1024 * 3; // 업로드 용량 3MB
		String ffilename = "";
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", 
							new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			ffilename = mRequest.getFilesystemName(param);
			HttpSession httpSession = request.getSession();
			MemberDto member = (MemberDto)httpSession.getAttribute("member");	// id가져오기 위한 member
			if(member != null) {
				String mid = member.getMid();
				String ftitle = mRequest.getParameter("ftitle");
				String fcontent = mRequest.getParameter("fcontent");
				String fip = request.getRemoteAddr();
				FileboardDao fDao = FileboardDao.getinstance();
				FIleboardDto dto = new FIleboardDto(0, mid, null, ftitle, fcontent, ffilename, null, 0, 0, 0, 0, fip);
				int result = fDao.write(dto);
				if(result == FileboardDao.SUCCESS) {
					HttpSession session = request.getSession(); // 세션은 request로 부터
					request.setAttribute("writeResult", "글쓰기 성공");
				}else {
					request.setAttribute("writeFailResult", "글쓰기 실패");
				}
			}else {
				request.setAttribute("writeResult", "로그인 해주세요");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
		// 서버에 업로드된 파일을 소스 폴더로 복사
		File serverFile = new File(path + "/" + ffilename);
		if(serverFile.exists()) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/Full-stack/sourse/07_jQuery/model2ex/WebContent/fileBoardUp/"+ffilename);
				byte[] bs = new byte[(int) serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt==-1) break;
					os.write(bs, 0, readByteCnt);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} // try-catch-finally
		} // if - serverFile
	}
}
