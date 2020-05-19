package com.lec.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
	
	
	// 웹 어플리케이션(컨텍스트) 종료할때 호출
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("JSP07 어플리케이션종료");
	}
	
	
	//웹 어플리케이션 (컨텍스트) 시작할때 호출 
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("JSP07 어플리케이션시작");
	}
	
}
