package com.lec.spring.environment;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class EnvMain {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		//Context → Environment → PropertySources
		ConfigurableApplicationContext ctx=new GenericXmlApplicationContext();
		ConfigurableEnvironment env=ctx.getEnvironment();//← ConfigurableApplicationContext 소속
		MutablePropertySources propertySources=env.getPropertySources();

		//PropertySources 에  마지막에 PropertySource 추가 
		
		try {
		//빈을 만들진 않았지만 만들기 위한 설정값들을 끌고온것.
		//PropertySource 하나를 생성하여 PropertySources에 추가: addLast() ← 끝에 추가
		propertySources.addLast(
				new ResourcePropertySource("classpath:admin.auth"));//IOException 잡아줘야해
		//이제, Environment를 통해 원하는 property에 접근 가능
		//굳이 어느 'PropertySource'의 '어느 property'를 지정할 필요가 없다.
		//'어느 property'에 대한 것만 요청하면 
		//PropertySources에 소속된 모든 PropertySource를 다 스캔해서 찾아낸다!
		System.out.println(env.getProperty("admin.id"));
		System.out.println(env.getProperty("admin.pw"));
		
		
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//load 는 GenericXmlApplicationContext에서 쓸수있어서 ConfigurableApplicationContext를 형변환
		GenericXmlApplicationContext gCtx=(GenericXmlApplicationContext)ctx;
		gCtx.load("classpath:appCtx1.xml"); //설정 로딩
		gCtx.refresh(); //빈 생성
		
		
		AdminConnection adminConnection=gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID: "+adminConnection.getAdminId());
		System.out.println("admin PW: "+adminConnection.getAdminPw());
		
		gCtx.close();
		
		System.out.println("Main 끝");

	}

}
