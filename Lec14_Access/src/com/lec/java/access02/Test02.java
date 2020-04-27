package com.lec.java.access02;

public class Test02 {

	private int privateNum;
	int defaultNum;
	protected int protectedNum;
	public int publicNum;//어디서나 사용 가능하다. 
//	protected 상속받은 class
//	default같은 패키지 내에
//	public어디서나
	
	private void privateMethod() {}
	void defaultMethod() {}
	protected void protectedMethod() {}
	public void publicMethod() {}	
	
	
}
