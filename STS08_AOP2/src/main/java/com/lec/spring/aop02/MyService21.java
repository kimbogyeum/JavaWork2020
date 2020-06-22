package com.lec.spring.aop02;

import com.lec.beans.Service;

public class MyService21 extends Service {

	@Override
	public void doAction() {
		
		//공통기능이 없다.여기를 이제 안건들이고 공통기능이 실행되게 할꺼야.
		
		printInfo();//핵심기능
	}


	
}
