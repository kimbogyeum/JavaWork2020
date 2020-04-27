package com.lec.java.switch02;

public class Switch02Main {

	public static void main(String[] args) {
		System.out.println("switch 연습");

		// 도전
		// switch ~ case 조건문을 사용해서
		// 짝수 이면 --> "짝수입니다"  출력
		// 홀수 이면 --> "홀수입니다"  출력

		
		int num=99;
		switch (num % 2) { //switch 안에는 값이 와야한다. int or int로 자동 형변환 될 수 있는것들 (byte, short, cha)(long은 안됨)
		case 0: //case 뒤에는 조건문같이 쓰면 안되고 숫자가 와야된다. 
			System.out.println("짝수입니다.");
			break;
		case 1:
			System.out.println("홀수입니다.");
			break;
		}
			
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









