package com.lec.java.casting;

public class CastingMain {
	/*
	 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
	 * 
	 * 		primitive type 에서 implicit casting 방향
	 * 
	 * 		byte → short → int → long → float → long  
	 *                 		↑
	 *                    char
	 * 
	 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
	 *      
	 *      (변환하고자 하는 타입명)변수/값
	 *      
	 *      
	 *            
	 */


	public static void main(String[] args) {
		System.out.println("형변환(Type Casting/Type Converting)");
		
		byte num1=123;
		int num2=123;
//		byte num3=num2; int type이 byte로 변환이 안되지
		
		byte num3=(byte)num2; //명시적 형변환
		System.out.println("num3: "+num3);
		
		//명시적 형변환시 주의점-> 데이터손실 발생 주의 
		byte num5=(byte)513;
		System.out.println("num5: "+num5);//1
		
		//ex
		double avg1=(99+88+78)/3; //우변항을 계산하면  int
		System.out.println("avg1= "+avg1);
		
		double avg2=(double)(99+88+78)/3;
		System.out.println("avg2= "+avg2);
		
		double avg3=(99+88+78)/3.0;
		System.out.println("avg3= "+avg3);
	
		
		
		
		

	}

}
