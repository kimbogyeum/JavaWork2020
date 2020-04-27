package com.lec.java.access03;

import com.lec.java.access04.TestPublic2;

//다른 패키지의 (default)클래스는 import 불가
//import com.lec.java.access04.MyDefault2; => error:not visible ==> 다른 패키지의 default class는 import가 안된다. 

import com.lec.java.access04.TestPublic;

// 클래스의 접근 권한 수식어: public, (default)
// 1. public class: 어디에서나 인스턴스 생성이 가능한 클래스
//   (주의) public 클래스의 이름은 .java 파일 이름과 반드시 같아야 함
// 2. (default) class: 같은 패키지에 있는 클래스들에서만 인스턴스 생성이 가능

public class Access03Main {

	public static void main(String[] args) {
		System.out.println("public, default 클래스");
		TestPublic t1=new TestPublic();//new뒤에 오는건 생성자. 매개변수 없으면 default 생성자
		//만약 import com.lec.java.access04.TestPublic; 으로 package 4를 import하면  package 3의 TestPublic이  package 4에 있는걸로 바뀜
		
		//같은 패키지에 있는 클래스에서는 인스턴스 생성(사용)가능
		MyDefault t2=new MyDefault();
		
		//다른 패키지에 있는 public클래스==>인스턴스 생성가능
		TestPublic2 t3= new TestPublic2();
		
		//다른 패키지에 있는 (default)클래스==>인스턴스 생성 불가능!
		//MyDefault2 t4=new MyDefault2();

		//다른 패키지의 클래스와 동일 이름의 클래스가 충돌된다면?==>직접 경로 다적어주기
		com.lec.java.access04.TestPublic t11= 
		new com.lec.java.access04.TestPublic();
		 
		
		
	} // end main()

} // end class Access05Main










