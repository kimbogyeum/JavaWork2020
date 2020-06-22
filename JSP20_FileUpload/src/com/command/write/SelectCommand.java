package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao=new WriteDAO(); //DAO 객체 생성
		WriteDTO [] arr=null;
		
		//첨부파일 정보도 update 화면에 보여주어야 한다. 
		FileDAO fileDao=new FileDAO();
		FileDTO [] fileArr=null;
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		try {
			//트랜잭션 수행
			arr=dao.selectByUid(uid);
			//request 에 담아서 "리스트"라는 이름으로 controller에 전달된다. 
			request.setAttribute("list", arr);
			
			if(arr!=null && arr.length==1) {
				fileArr=fileDao.selectFilesByWrUid(uid);
				request.setAttribute("file", fileArr);
			}
			
		} catch(SQLException e) {
			//만약 CP 사용하면 
			//NaimingException 도 처리해야한다. 
			e.printStackTrace();
		}

	}
}
