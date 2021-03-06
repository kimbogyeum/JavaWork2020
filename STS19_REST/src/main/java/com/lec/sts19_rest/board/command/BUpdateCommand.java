package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		
		
//		BWriteDAO dao = new BWriteDAO();
//		int cnt = dao.update(dto);
//		model.addAttribute("result", cnt);
		
		
		//MyBatis 사용
		IWriteDAO dao=C.sqlSession.getMapper(IWriteDAO.class);
		//model.addAttribute("result",dao.update(dto));
		//두개의 매개변수 가진 버전-> MapperScan, Param 사용한 버전 p
		model.addAttribute("result",dao.update(dto.getUid(),dto));
		
		
		
	}

}












