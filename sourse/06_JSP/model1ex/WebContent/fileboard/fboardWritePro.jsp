<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 파일 첨부했으면 저장 -->
	<%
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024 * 1024 * 5;	// 최대 업로드 용량
		String ffilename = null;	// 서버에 저장된 첨부파일 이름
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
			Enumeration<String> paramNames = mRequest.getFileNames();
			String param = paramNames.nextElement();
			ffilename = mRequest.getFilesystemName(param);		// 서버에 저장된 첨부파일 이름	
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// 서버에서 소스 폴더로 파일 복사
		if(ffilename != null){
			InputStream  is = null;
			OutputStream os = null;
			try{
				File serverFile = new File(path + "/" + ffilename);
				if(serverFile.exists()){	// serverFile이 존재 -> 복사
					is = new FileInputStream(serverFile);		// 서버에 업로드 된 파일
					os = new FileOutputStream("C:/JK/sourse/06_JSP/model1ex/WebContent/fileboardUpload/" + ffilename);		// 소스폴더로 복사될 파일
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int nReadCnt = is.read(bs);
						if(nReadCnt == -1) break;
						os.write(bs, 0, nReadCnt);
					}
					System.out.println("서버에 업로드한 파일을 소스폴더로 복사 완료");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				try{
					if(os!=null) os.close();
					if(is!=null) is.close();
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
			}
		}
		// 파라미터 정보 가져오기
		String pageNum = mRequest.getParameter("pageNum");
		int 	 fnum = Integer.parseInt(mRequest.getParameter("fnum"));
		String cid = ((CustomerDto)session.getAttribute("customer")).getCid();
		String fsubject = mRequest.getParameter("fsubject");
		String fcontent = mRequest.getParameter("fcontent");
		String fpw = mRequest.getParameter("fpw");
		int    fref = Integer.parseInt(mRequest.getParameter("fref"));
		int    fre_step = Integer.parseInt(mRequest.getParameter("fre_step"));
		int    fre_level = Integer.parseInt(mRequest.getParameter("fre_level"));
		String fip = request.getRemoteAddr();
		// dto 생성
		FileboardDao fDao = FileboardDao.getInstance();
		FileboardDto fDto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fref, fre_step, fre_level, fip);
		// dto 생성 후 fnum == 0 : dao를 통해 원글쓰기
		// dto 생성 후 fnum != 0 : dao를 통해 답변글쓰기
		int result;
		if(fnum==0){ // 원글쓰기
			result = fDao.insertFileboard(fDto);
		}else{	// 답변글 쓰기
			result = fDao.reply(fDto);
		}
		if(result == FileboardDao.SUCCESS){
	%>
			<script>
				alert('<%=fnum==0? "글쓰기 완료" : "답글 쓰기 완료"%>');
				location.href = 'fboardList.jsp?pageNum=<%=pageNum%>';
			</script>
	<%}else{%>
		<script>
				alert('<%=fnum==0? "글쓰기 실패" : "답글 쓰기 실패"%>');
				history.back();
			</script>
	<%}%>
</body>
</html>