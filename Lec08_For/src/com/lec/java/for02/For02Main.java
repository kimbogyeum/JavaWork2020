package com.lec.java.for02;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		
		int i,j;
		for(i=2;i<=9;i++) {
			System.out.println(+i+"단");
			for(j=1;j<=9;j++) {
				System.out.println(i+"*"+j+"="+(i*j));
			}
			System.out.println("\n");
		}
			
	//2 x 2 = 4
	//3 x 3 = 9.. 이런식으로 짜보기
			
	for(i=2;i<=9; i++) {
		System.out.println(i+" x "+ i+ " = "+(i*i));
	}
		
		
		

	} // end main()

} // end class For02Main












