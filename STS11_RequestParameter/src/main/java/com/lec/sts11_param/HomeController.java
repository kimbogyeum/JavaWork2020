package com.lec.sts11_param;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.beans.WriteDTO;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	// parameter 추출
	// handler 메소드에서도 서블릿에서 보았던 HttpServletRequest, HttpServletResponse 매개변수 가능!
	@RequestMapping(value = "/member/delete") // -> /member/delete?id=34
	public String delMember(HttpServletRequest request,Model model) {//model이랑 request랑 자리 바꿔도 됨.type 따라가는거지 순서 따라가는게 아님. 
		String id=request.getParameter("id");
		model.addAttribute("mbId",id);

		return "member/delete";
	}
	
	
	//주소에 직접 /member/regOk 적는건 Get방식, Post방식이니까 이런 방식에서 안먹는다. 일전에는 됬었지만 Spring에서는 안됨!
	@RequestMapping(value = "/member/regOk", method = RequestMethod.POST)
	public String regOkMember() {
		
		System.out.println("/member/regOk : POST ");
		return "member/regOk";
	}
	
	
	// 이건 되겠쥐~? 주소에 직접 /member/regOk 적는건 Get방식
	@RequestMapping(value = "/member/regOk", method = RequestMethod.GET)
	public String regOkMember(Model model) {
		
		System.out.println("/member/regOk : GET ");
		return "member/regOk";
	}
	
	@RequestMapping(value = "/member/regist")
	public String registMember() {
		return "member/regist";
	}
	
	//GET, POST 둘다 다됨. 
	@RequestMapping(value="/member/regOk2", method = {RequestMethod.GET,RequestMethod.POST})
	public String regOkMember2() {
		return "member/regOk";
	}
	
	
	
	//handler에 
	//request parameter 의 name 값과 '같은 이름의 매개변수' 가 있으면
	//바로 그 매개변수가 request parameter 값을 받아온다.

	//@RequestMapping("/member/find")
	//public String findMember(String id, String name, Model model) {
	//public String findMember(Model model, String name, int id) {  // 순서 무관!
	
	// 숫자타입으로 하면 바로 parsing 하여 받는다.
	//public String findMember(Model model, String name, double id) {
	
	// 동일한 name의 request parameter 들.
//	public String findMember(Model model, String [] name, int [] id) {
//		model.addAttribute("id", Arrays.toString(id));
//		model.addAttribute("name", Arrays.deepToString(name));
//		
//		return "member/find";
//	}

	
	
	
	//handler 메소드의 ‘매개변수 이름’  을  request parameter 와 일치시켜주기 어려울때 @RequestParam 사용
	@RequestMapping("/member/find")
	public String findMember(Model model, 
			@RequestParam("id")String userid, //name "id" parameter 값을 받아온다. 
			@RequestParam("name")String username) {
		model.addAttribute("id",userid);
		model.addAttribute("name",username);
		
		return "member/find";
	}
	
	
	//-------------------------------
	//커맨드 객체(Command Object) 사용
	
	@RequestMapping("/board/write")
	public String writeBoard() {
		return "board/write";
	}
	
	//기존 방식으로 form 받아오는거 구현하기
	//매 parameter 들을 매개변수화? 해야한다.힘들다.
	@RequestMapping(value = "/board/writeOk",method = RequestMethod.POST)
//	public String writeOkBoard(
//			Model model,
//			@RequestParam("name")String name,
//			@RequestParam("subject")String subject,
//			@RequestParam("content")String content
//			) {
//		
//			WriteDTO dto=new WriteDTO();
//			dto.setName(name);
//			dto.setSubject(subject);
//			dto.setContent(content);
//			
//			model.addAttribute("dto",dto);
//			return "board/writeOk";
//	}
	
	//command 객체 사용해보자
	public String writeOkBoard(WriteDTO dto) {

			return "board/writeOk";
	}
	
	
	
	
}
