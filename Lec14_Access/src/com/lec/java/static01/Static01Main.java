package com.lec.java.static01;

import java.util.Scanner;

// 클래스에 선언된 멤버 변수/멤버 메소드는
// static 여부에 따라 아래와 같이 불려진다

// 인스턴스 변수: 
//   static 이 안붙은 변수
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 변수
// 인스턴스 메소드:
//   static 이 안 붙은 메소드
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 메소드

// 클래스 변수(static variable):
//   클래스의 멤버 변수들 중에서,
//   인스턴스를 생성하지 않아도 사용할 수 있는 변수
// 클래스 메소드(static 메소드):
//   인스턴스를 생성하지 않아도 사용할 수 있는 메소드


public class Static01Main {

	public static void test() {
		System.out.println("Hello static!");
	}
	public void test2() {
		System.out.println("Hello non static!");
	}
	
	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드 vs 클래스 변수/메소드");
		
		test();
		//test2(); ->에러나는 이유: main에서 static이므로 static인 메소드만 사용할 수 있음.
		//static 은 non-static 멤버 사용 불가
		
		//인스턴스 생성 이후에는 사용가능
		Static01Main tc=new Static01Main();
		tc.test2();
		
		
	} // end main()

} // end class Static01Main











