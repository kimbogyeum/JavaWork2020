package com.command.write;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.WriteDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		WriteDAO dao = new WriteDAO();
		FileDAO fileDao=new FileDAO(); //첨부파일
		
		//---------------------------------------------------------
		// 1. 업로드 파일(들)
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath("upload");
		
		int maxPostSize = 5 * 1024 * 1024;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(
					request,
					saveDirectory,
					maxPostSize,
					encoding,
					policy
					);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//궁극적으로 originalFileNames, fileSystemNames 를 만들기 위함!
		List<String> originalFileNames=new ArrayList<String>();
		List<String> fileSystemNames=new ArrayList<String>();
		
		
		Enumeration names=multi.getFileNames(); //type="file"의 요소들의 name 추출
		while(names.hasMoreElements()) {
			String name=(String)names.nextElement();
			String originalFileName=multi.getOriginalFileName(name);
			String fileSystemName=multi.getFilesystemName(name);
			System.out.println("첨부파일: "+originalFileName+"->"+fileSystemName);

			if(originalFileName !=null && fileSystemName !=null) {
				originalFileNames.add(originalFileName);
				fileSystemNames.add(fileSystemName);
			}
			
		}// end while
		
		
		//---------------------------------------------------------
		
		// 2. 삭제될 첨부파일(들)
		String [] delFiles= multi.getParameterValues("delfile");
		if(delFiles !=null || delFiles.length>0) {
			
			int[] delFileUids=new int[delFiles.length];
			for(int i=0; i<delFiles.length; i++) {
				delFileUids[i]=Integer.parseInt(delFiles[i]);
			}
			try {
				fileDao.deleteByUid(delFileUids, request); //물리적 삭제 + DB 테이블 삭제
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}//end if
		
		
		//---------------------------------------------------------
		// 3. 입력한 값을 받아오기 --> 글 수정
		int uid = Integer.parseInt(multi.getParameter("uid")); //첨부파일 수정을 위해 multipart request 쓰면 request.getParameter("uid")이렇게 쓰면 안됨. 
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");

		// 유효성 체크  null 이거나, 빈문자열이면 이전화면으로 돌아가기
		if(subject != null && subject.trim().length() > 0){			
			try {			
				cnt = dao.update(uid, subject, content);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end if

		
		//------------------------------------------------------------
		// 추가된 첨부파일(들)
		
		fileDao=new FileDAO();
		try {
			fileDao.insert(uid,originalFileNames, fileSystemNames);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("uid", uid); // Multipart로 받은 뒤 updateOk.jsp 로 넘겨야 한다. 
		request.setAttribute("result", cnt);

	}

}
