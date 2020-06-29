package com.lec.sts12_validation;

import java.util.List;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.beans.WriteDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}
	
	@RequestMapping("writeOk.do")
	public String writeOk(@ModelAttribute("w")@Valid WriteDTO dto,
			BindingResult result) {// validator가 유효성 검사를 한 결과가 담긴 객체(BindingResult).추가하니까 uid 빈칸이어도 값 넘어감
		System.out.println("writeOk():" + dto.getUid()+":" +dto.getName());
		//System.out.println("에러개수: "+ result.getErrorCount());// 바인딩과정에서 발생한 에러개수 
		
		
		System.out.print(" validate 전 ");showErrors(result);//spring기본검사만 한 후 
		
		String page="board/writeOk";

		//나만의 validator 생성
		BoardValidator validator=new BoardValidator();
		validator.validate(dto, result);
		
		System.out.print(" validate 후 ");showErrors(result);
		
		if(result.hasErrors()) {//에러가 하나라도 있으면
			page="board/write"; //원래 폼으로 돌아가기!
		}
		return page;
	}
	
	//(도우미method)error에 담겨있는 에러 들을 다 출력하기
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러개수: " + errors.getErrorCount());
			System.out.println("\t[field]\t|[code]");
			List<FieldError> errList=errors.getFieldErrors();
			for(FieldError err: errList) {
				System.out.println("\t"+err.getField()+"\t|"+err.getCode());
			}
		}else {
			System.out.println("에러없음");
		}
	}
	
	
	//이 컨트롤러 클래스의 handler 에서 폼 데이터를 바인딩 할 때 검증하는 개체 지정
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BoardValidator());
	}
	
}
