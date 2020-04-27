package com.lec.java.while01;

/*
 	조건식이 true 인 동안 while 블럭 반복
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int count =1;
		while(count<=10) {
			System.out.println(count);
			count++;
		}//end while
		
		System.out.println();
		
		
		int num=10;//초기식
		while(num>=1){//조건식
			System.out.println(num);
			num--;//증감식
		}

	} // end main()
	
} // end class While01Main









