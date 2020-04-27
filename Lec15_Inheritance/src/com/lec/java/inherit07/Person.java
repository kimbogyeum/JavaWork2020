package com.lec.java.inherit07;
//class 앞에 final 붙이면 final class로써 더이상 상속 불가
//-> BusinessPerson쪽 다에러남

public class Person {
	private String name;

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public void showInfo() {
		System.out.println("이름: "+name);
	}
	
	public final void whoAreYou() {//final method: 더이상 오버라이딩 불가
		System.out.println("이름: "+name);
	}

}
