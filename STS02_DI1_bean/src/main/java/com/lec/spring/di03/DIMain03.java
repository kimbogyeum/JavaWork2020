package com.lec.spring.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class DIMain03 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		//ApplicationContext(컨테이너) 생성, ApplicationContext 객체를 만드는 시점에서 bean 객체가 생성된다!
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext("classpath:scoreCtx.xml");
		System.out.println("컨테이너 생성\n");
		
		Score score=null;
		
		//외부에서 만들어진 객체 주입(Injection)
		score=ctx.getBean("myScore1",Score.class);//두번째 매개변수가 class면 class형으로 타입 변환
		System.out.println(score);
		
		//getBean(id)는 Object리턴. 형변환해서 사용가능
		score=(Score)ctx.getBean("myScore2");//두번째 매개변수가 없으면  object타입으로 변환 
		System.out.println(score);
		
		//scoreCtx에서 index 정해준 경우 모호성을 없애기 위해
		score=(Score)ctx.getBean("myScore3");
		System.out.println(score);
		
		score=(Score)ctx.getBean("myScore4");
		System.out.println(score);
		
		score=(Score)ctx.getBean("myScore5");
		System.out.println(score);
		
		score=(Score)ctx.getBean("myScore6");
		System.out.println(score);
		
		score=(Score)ctx.getBean("myScore7");
		System.out.println(score);
		
		score=(Score)ctx.getBean("myScore8");
		System.out.println(score);
		
		System.out.println("생성된 bean의 개수: "+ctx.getBeanDefinitionCount());
		for(int i=1; i<=ctx.getBeanDefinitionCount();i++) {
			System.out.println(ctx.getBean("myScore"+i));//출력값이 object인데 toString....있으니까
		}
		
		ctx.close();
		
		
		System.out.println("Main 종료");

	}

}
