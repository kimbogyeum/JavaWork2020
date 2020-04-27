package com.lec.java.final01;

public class Final01Main {
	
	//2.final: 멤버변수는 선언과 동시에 초기화 해야한다. 
	final int NUM=1;
	//ctrl x =소문자->대문자
	//ctrl y =대문자->소문자
	
	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");
		
		//1.final: 지역변수
		int num1=1;
		num1=10;
		
		final int num2=1;
		//num2=10;=> 변경불가
		
		final int num3;
		num3=1;//final 지역변수는 선언이후에 초기화 가능
		

	} // end main()

} // end class Final01Main










