package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		for(int dan=2;dan<=9;dan++) {
			System.out.println("===="+dan+" 단"+"====");
			for(int n=1;n<=9;n++) {
				System.out.println(dan+" x "+ n + " = "+ (dan * n));
			}
			System.out.println();
		}
		
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		int dan=2;
		
		while(dan<=9) {
			System.out.println("="+dan+" 단"+"=");
			int n=1; //직전에서 초기화 해줘야해!!!내가 잘 못하는 부분. 
			while(n<=9) {
				System.out.println(dan+" x "+ n + " = "+ (dan * n));
				n++;
				
			}
			System.out.println();
			dan++;
			
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















