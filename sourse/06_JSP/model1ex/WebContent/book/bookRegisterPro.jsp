<%@page import="com.lec.dao.BookDao"%>
<%@page import="com.lec.dto.BookDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
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
	 <%
		String path = request.getRealPath("bookImg");
		int maxSize = 1024 * 1024 * 3;	// 최대 업로드 사이즈
		String[] images = {"",""};
		MultipartRequest mRequest = null;		// try 안이 아닌 밖에 설정하는 이유 : 받을 파라미터가 많기 때문
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", 
									new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			int idx = 0;
			while(paramNames.hasMoreElements()){
					String param = paramNames.nextElement();
					images[idx] = mRequest.getFilesystemName(param);
					System.out.println(idx + "번째 처리한 파라미터 : " + param + "/파일이름 : " + images[idx]);
					idx++;
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// 서버 파일 => 소스폴더로 복사
		for(String imgfile : images){
			InputStream  is = null;
			OutputStream os = null;
			File serverFile = new File(path + "/" + imgfile);
			if(serverFile.exists()){
				try{
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("C:/JK/sourse/06_JSP/model1ex/WebContent/bookImg/" + imgfile);
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int readByteCnt = is.read(bs);	// bs만큼 is 서버파일 읽기
						if(readByteCnt == -1) break;		// 파일이 끝이면 break
						os.write(bs, 0, readByteCnt);
					}
				}catch(IOException e){
					System.out.println(e.getMessage());
				}finally{
					try{
						if(os != null) os.close();
						if(is != null) is.close();
					}catch(IOException e){
						System.out.println(e.getMessage());
					}
				} //try-catch-finally
			} // if 
		} // for
		// book 테이블에 저장
		String btitle 	 = mRequest.getParameter("btitle");
		int    bprice 	 = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimage1	 = images[1] != null? images[1] : "noImg.png";
		String bimage2	 = images[0] != null? images[0] : "NOTHING.JPG";
		String bcontent  = mRequest.getParameter("bcontent");
		if(bcontent == null) bcontent = "";
		int    bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		// String ip = request.getRemoteAddr();	// ip가 필요한 경우 request 이용
		BookDto dto = new BookDto(0, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, null);
		BookDao bDao = BookDao.getInstance();
		int result = bDao.insertBook(dto);
		if(result == bDao.SUCCESS){
	%>
			<script>
				alert('책 등록 성공');
				location.href='bookList.jsp';
			</script>
	<%}else{%>
			<script>
				alert('책 등록 실패');
				location.href='bookRegister.jsp';
			</script>
	<%}%>
</body>
</html>