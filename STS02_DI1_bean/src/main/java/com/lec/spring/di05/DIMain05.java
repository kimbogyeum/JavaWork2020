package com.lec.spring.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class DIMain05 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		//다형성에 의해서 Abstract 가 Generic의 조상인걸 알수있쥐...
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext("classpath:studentCtx2.xml");
		System.out.println("--컨테이너 생성--");
		
		Score score=null;
		score=(Score)ctx.getBean("score1");
		System.out.println(score);
		
		score=(Score)ctx.getBean("score2");
		System.out.println(score);
		
		System.out.println(ctx.getBean("stu1"));//생성자에 
		System.out.println(ctx.getBean("stu2"));//기본생성자에 setter가 호출
		
		ctx.close();
		System.out.println("Main 종료");

	}

}
