package com.lec.spring.main01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class DIMain01 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=new GenericXmlApplicationContext("classpath:scoreCtx.xml");
		Score score=null;
		score=ctx.getBean("myScore1",Score.class);
		System.out.println(score);
	}

}
