package com.lec.java.class03;

public class Number {
	//멤버변수
	private int num;
	private char ch;
	
	//생성자
	//디폴트 생성자
	public Number() {
		
	}
	//매개변수 있는 생성자
	public Number(int num, char ch) {
		this.num=num;//this:자기자신(인스턴스)를 가르킴
		this.ch=ch;
		
	}
	//메소드
	// getter: 멤버 변수의 값을 리턴해 주는 메소드
	// setter: 멤버 변수의 값을 변경해 줄 수 있는 메소드
	
	//get변수이름()
	//set변수이름()
	//Camel notation 적용

	public int getNum() {
		return this.num;
	}
	
	public void setNum(int num) {
		if(num>=0)
		this.num=num;
	}
	
	public int getch() {
		return this.ch;
	}
	
	public void setch(char ch) {
		this.ch=ch;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
