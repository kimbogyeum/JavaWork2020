package com.lec.java.exception08;

import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);
	
	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException {
		System.out.println("나이 입력:");
		int age = sc.nextInt();

		if(age<0||age>150) {
			AgeInputException ex=new AgeInputException();
			throw ex;			
		}
		return age;
	} // end inputAge()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");

		while(true) {
			try {
				int age=inputAge();
				System.out.println("나이는"+age+"살입니다.");
				break;
			} catch (AgeInputException e) {
				System.out.println("잘못된 나이 입력값입니다.");
				e.printStackTrace();
			}
		}
		
		sc.close();
		
		System.out.println("프로그램 종료...");
		
	} // end main()

} // end class Exception08Main












