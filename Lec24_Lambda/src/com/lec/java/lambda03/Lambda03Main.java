package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
//		 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
		//덧셈연산
		Operable lambda01=new OperableImple();
		double result=lambda01.operate(11,12);
		System.out.println("result= "+result);
//		 방법 2) 익명클래스
		//뺄셈연산
		Operable lambda02=new Operable() {
			
			@Override
			public double operate(double x, double y) {
				return x-y;
			}
		};
		result=lambda02.operate(2, 1);
		System.out.println("result= "+result);
		
//		 방법 3) 람다 표현식 lambda expression
		//제곱연산
		Operable lambda03=(x,y)->Math.pow(x, y);
		result=lambda03.operate(3, 4);
		System.out.println("result= "+result);
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class
interface Operable{//public을 쓰려면 항상 자기 파일이름이랑 같아야한다.
	public abstract double operate(double x, double y);
}

class OperableImple implements Operable{

	@Override
	public double operate(double x, double y) {
		return x+y;
	}
	
}

