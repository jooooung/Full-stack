package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.FileboardDao;
import com.lec.ex.dto.FIleboardDto;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fileBoardUp");
		int maxSize = 1024 * 1024 * 3; // 업로드 용량 3MB
		String ffilename = "", dbFileName = null;
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", 
							new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			ffilename = mRequest.getFilesystemName(param);
			dbFileName = mRequest.getParameter("dbfileName");
			if(ffilename == null) {
				ffilename = dbFileName;
			}
			HttpSession httpSession = request.getSession();
			MemberDto member = (MemberDto)httpSession.getAttribute("member");	// id가져오기 위한 member
			if(member != null) {
				int fid = Integer.parseInt(mRequest.getParameter("fid"));
				String ftitle = mRequest.getParameter("ftitle");
				String fcontent = mRequest.getParameter("fcontent");
				String fip = request.getRemoteAddr();
				FileboardDao fDao = FileboardDao.getinstance();
				FIleboardDto dto = new FIleboardDto(fid, null, null, ftitle, fcontent, ffilename, null, 0, 0, 0, 0, fip);
				int result = fDao.modify(dto);
				if(result == FileboardDao.SUCCESS) {
					HttpSession session = request.getSession(); // 세션은 request로 부터
					request.setAttribute("modifyResult", "글수정 성공");
				}else {
					request.setAttribute("modifyResult", "글수정 실패");
				}
			}else {
				request.setAttribute("writeResult", "로그인 해주세요");
			}
			request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("modifyResult", "글수정 실패");
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
