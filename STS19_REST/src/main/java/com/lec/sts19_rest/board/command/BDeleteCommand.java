package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		
		
//		BWriteDAO dao = new BWriteDAO();
//		int cnt = dao.deleteByUid(uid);
//		model.addAttribute("result", cnt);		
		
		
		//myBatis 사용
		IWriteDAO dao=C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list",dao.deleteByUid(uid));
		
		
	}

}














