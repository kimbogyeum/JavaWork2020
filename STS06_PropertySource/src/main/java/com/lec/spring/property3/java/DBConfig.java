package com.lec.spring.property3.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.lec.spring.property2.xml.DBConn;

@Configuration
public class DBConfig {
	//bean 객체로 하는게 아니니까 getter/setter 안해도 됨여.
	
	@Value("${admin.id}")
	private String id;
	@Value("${admin.pw}")
	private String pw;
	@Value("${db.url}")
	private String url;
	@Value("${db.port}")
	private String port;
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {//id 이름은 Properties인 bean을 만든거야
		
		System.out.println("Properties() 호출");
		PropertySourcesPlaceholderConfigurer configurer=
				new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations=new Resource[2];
		locations[0]=new ClassPathResource("admin.auth");
		locations[1]=new ClassPathResource("db.info");
		configurer.setLocations(locations);//위에서 만든 configurer에 location 세팅해주기
		
		return configurer;
	}
	
	
	@Bean
	public DBConn dbConfig() {
		DBConn conn=new DBConn();
		
		//config 자바의 멤버변수
		conn.setId(id);
		conn.setPw(pw);
		conn.setUrl(url);
		conn.setPort(port);
		return conn;
	}
	
	
}
