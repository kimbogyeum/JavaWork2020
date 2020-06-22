package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@RequestMapping(value = "/list")
	public String listBoard() {
		return "board/list_board";
	}

	@RequestMapping(value = "/write")
	public String writeBoard() {
		return "board/write_board";
	}

	@RequestMapping(value = "/view")// -> /board+/list = /board/list
	public String viewBoard() {
		return "board/view_board";
	}

	@RequestMapping(value = "/update")// -> /board+/list = /board/list
	public String updateBoard() {
		return "board/update_board";
	}
	
	@RequestMapping(value = "/delete")// -> /board+/list = /board/list
	public String deleteBoard() {
		return "board/delete_board";
	}
}
