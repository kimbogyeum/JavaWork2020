package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao=new WriteDAO(); //DAO 객체 생성
		WriteDTO [] arr=null;
		
		
		
		try {
			//트랜잭션 수행
			arr=dao.select();
			//request 에 담아서 "리스트"라는 이름으로 controller에 전달된다. 
			request.setAttribute("list", arr);
			
		} catch(SQLException e) {
			//만약 CP 사용하면 
			//NaimingException 도 처리해야한다. 
			e.printStackTrace();
			
		}
		

	}

}
