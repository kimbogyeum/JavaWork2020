package 선택제어문.자가진단07;

import java.util.Scanner;

/*
 * 영문 대문자를 입력받아 

'A'이면 “Excellent”, 

'B'이면 “Good”, 

'C'이면 “Usually”, 

'D'이면 “Effort”, 

'F'이면 “Failure”, 

그 외 문자이면 “error” 라고 출력하는 프로그램을 작성하시오.
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str=sc.next();
		
		if (str.equals("A")) {
			System.out.println("Excellent");
		}else if(str.equals("B")){
			System.out.println("Good");
		}else if(str.equals("C")) {
			System.out.println("Usually");
		}else if(str.equals("D")) {
			System.out.println("Effort");
		}else if(str.equals("F")) {
			System.out.println("Failure");
		}else {
			System.out.println("error");
		}
		
		sc.close();
		
	}
}
