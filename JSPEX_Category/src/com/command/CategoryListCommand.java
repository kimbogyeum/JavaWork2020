package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;


public class CategoryListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CategoryDAO dao = new CategoryDAO();  // DAO 객체 생성
		CategoryDTO [] arr = null;  
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL

		//관련 세팅값들

		String depth=request.getParameter("depth");
		String parent=request.getParameter("parent");
		
		
		if(depth==null) {
			try {
				arr=dao.select();
				status="OK";
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
		

			try {
				
				
				int dep=Integer.parseInt(depth);
				int par=Integer.parseInt(parent);
	
				dao = new CategoryDAO();
				arr = dao.selectFrom(dep,par);
				if(arr == null) {
					message.append("[리스트할 데이터가 없습니다]");
				} else {
					status = "OK";
				}
				
			} catch(SQLException e) {
				//e.printStackTrace();
				message.append("[트랜잭션 에러:" + e.getMessage()+ "]");
			} // end try
			
			
		}//end if
		
		
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);

		
	}//end execute()

}//end Command
