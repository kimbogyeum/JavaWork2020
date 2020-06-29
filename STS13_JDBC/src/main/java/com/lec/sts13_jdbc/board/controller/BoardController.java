package com.lec.sts13_jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.sts13_jdbc.board.C;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;
import com.lec.sts13_jdbc.board.command.BCommand;
import com.lec.sts13_jdbc.board.command.BListCommand;
import com.lec.sts13_jdbc.board.command.BWriteCommand;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BCommand command;
	private JdbcTemplate template;
	
	public BoardController() {
		super();
		System.out.println("BoardController 생성");//서버 가동하는 도중에 생김
	}


	@Autowired
	public void setTemplate(JdbcTemplate template) {//Jdbc templete는 외부에서 생성되었고 주입받아서 쓰는거다. 
		System.out.println("setTemplate() 호출");//서버 가동하는 도중에 생김
		this.template = template;
		C.template=template;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		command=new BListCommand();
		command.execute(model);
		return "board/list";
	}
	
	@RequestMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	}
	
	
	@RequestMapping(value="/writeOk.do",method=RequestMethod.POST)
	public String writeOK(BWriteDTO dto,Model model) {
		model.addAttribute("dto",dto);
		new BWriteCommand().execute(model);
		return "board/writeOk";
	}
	
	
	
}
