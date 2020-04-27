package com.lec.java.inherit03;

//하나의 부모에서만 상속받을 수 있다. => 단일상속
//c++에서는 다중상속도 가능하다. 
public class BusinessPerson extends Person {

	String company;
	
	public void showInfo() {
		whoAmI();//whoAmI 부모로부터 호출하기 
		System.out.println("회사는"+company+" 입니다.");
	
	}

	
}
