package com.lec.java.static03;

public class Test {

	private int num;
	
	static int count=0;
	
	
	//1. 기본생성자 private로 만들기
	private Test() {
		count++;
		System.out.println(count+"번째 인스턴스 생성");
	}
	//2. static변수 하나 만들기
	private static Test instance=null;
	
	//3. 인스턴스를 하나만 만들 수 있도록 하기
	public static Test getInstance() {
		if(instance==null) {
			instance=new Test(); //인스턴스 생성!
		}
		return instance;
	}
	
	
	//getter & setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}

