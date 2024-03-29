package com.lec.spring.di01;

import com.lec.spring.MessageBean;
import com.lec.spring.MessageEng;
import com.lec.spring.MessageKor;

/*
 * 
 * Dependency Injection(DI, 의존주입)
 * 필요한 객체를 '누가' 만들어 사용하나?
 * 
 * 방법 1: 직접만들기
 * 
 * 
 * */

public class DIMain01 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		MessageBean msg=null;
		
		//필요한 MessageBean 객체를 
//		msg=new MessageKor();//직접 만들어(new)사용
//		msg.sayHello();
		
		//의존하고 있던 객체의 버전등이 업그레이드 되면(설계가 변경되면)
		//의존하고 있던 객체를 재컴파일 해야한다.(수정해야한다.)
		
		msg=new MessageEng();
		msg.sayHello();

		System.out.println("Main종료");
		
	}

}
