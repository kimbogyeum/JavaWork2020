package com.lec.java.wrapper01;

/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double
 * Wrapper 클래스는 immutable하다. 
 */

/*
 * ----JVM의 구조----(Wrapper)
 * M.A
 * :123
 *		 
 * Heap
 * : integer(123)(0x100)    
 * : integer(123)(0x200)
 * (주소비교==, 내용비교equals())
 * : integer(123)(0x300)
 * 
 * Stack
 * :num1(0x100),num2(0x200)
 * :num3(0x300)
 * :num4(0x200)//num2,num4는 메모리 절약상 동일한 literal인경우 같은 주소로!
 */
public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();
		
		Integer i1=100;//reference<==primitive
		i1=i1+200; //reference가 산술연산??
		System.out.println("i1="+i1);//300
		//Wrapper 클래스는 마치 primitive 타입처럼 동작한다. 

		// 1. 생성자 이용
		Integer num1=new Integer(123);
		System.out.println("num1= "+num1);
		
		
		// 2. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		Integer num2=Integer.valueOf(123);
		System.out.println("num2= "+num2);
		
		if(num1==num2) {//주소비교
			System.out.println("==같다");
		}else {
			System.out.println("==다르다");
		}
		
		if(num1.equals(num2)) {//내용비교
			System.out.println("equals()같다");
		}else {
			System.out.println("equals()다르다");
		}
		
		
		// 3. new Integer() VS Integer.valueOf()
		
		
		
		
		Integer num3=new Integer(123);//new는 새로운 instance생성
		Integer num4=Integer.valueOf(123);
		//valueOf()는 생성한 object를 cache에 둔다. 전에 만든걸 기억해놓는것. 
		//동일 literal로 valueOf()생성하면, 기존의 생성된 Object를 리턴한다. 
		//왜? 메모리절약때문에!
		
		//new로 생성한것들끼리 비교
		if(num1==num3) {
			System.out.println("생성자: 같은참조");
		}else {
			System.out.println("생성자: 다른참조");//다르다
		}
		//valueOf()로 생성한것들끼리 비교
		if(num2==num4) {
			System.out.println("valueOf(): 같은참조");
		}else {
			System.out.println("valueOf(): 다른참조");//같다.
		}
		
		// 4. literal 상수로 생성
		System.out.println();
		Integer num5=123;
		//Integer.valueOf(123)과 동일한 코드가 동작됨!(Auto-Boxing)
		if(num4==num5) {
			System.out.println("literal 같은참조");
		}else {
			System.out.println("literal 다른참조");
		}
		
		
		// 5. valueOf(문자열) 가능!
		Integer num6=Integer.valueOf("123");
		System.out.println(num6);
		if(num6==num5) {
			System.out.println("같은참조");
		}else {
			System.out.println("다른참조");
		}
		
		// 6. 산술 연산 가능
		num6*=2;//Wrapper의 연산결과는 새로운 Wrapper생성(immutable!)
		System.out.println(num6);
		
		if(num6==num5) {
			System.out.println("같은참조");
		}else {
			System.out.println("다른참조");
		}//Wrapper class는 immutable이니까 원래 num6의 값을 변형시킨게 아니니까 다른 참조가 나옴
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















