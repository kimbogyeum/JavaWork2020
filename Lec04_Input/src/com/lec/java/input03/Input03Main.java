package com.lec.java.input03;

import java.util.Scanner;

public class Input03Main {

	public static void main(String[] args) {
		System.out.println("nextLine() vs next()");
		
		//nextLine()
		Scanner sc=new Scanner(System.in);
		System.out.print("여러단어의 문장을 입력: ");
		String line=sc.nextLine(); //'\n'까지 한 라인 전체를 입력
		System.out.println("line: "+line);
		
		
		
		// next()
		//다음 단어(token)을 받아서 String으로 결과 리턴
		System.out.print("여러 단어의 문장을 입력: ");
		
		String token1=sc.next();
		System.out.println("token1: "+token1);
		
		
		//next()를 또 실행시키면
		//기존의 버퍼에 담겨 있는 내용들이 담긴다.
		
		String token2=sc.next();
		System.out.println("token2: "+token2);
		
		String token3=sc.next();
		System.out.println("token3: "+token3);
		
		
		//nextInt(), nextDouble()....모두 next()처럼 동작함.
		//따라서 숫자타입도 여러개를 '한줄'로 입력받을 수 있다. 
		System.out.println("숫자 3개(int, double, int)를 입력받으세요> ");
		int i1=sc.nextInt();
		double d1=sc.nextDouble();
		int i2=sc.nextInt();
		
		System.out.println("i1, d1, i2:"+ i1+","+ d1+","+ i2);
		
		sc.close();
		

	}//end main

}//end class
