package 함수1.자가진단02;

import java.util.Scanner;

/*
 * 반지름의 길이를 전달받아 넓이를 출력하는 함수를 작성하고 반지름의 길이를 입력받아 함수를 호출하여 넓이를 출력하는 프로그램을 작성하시오.
(원주율은 3.14로 하고 반올림하여 소수 둘째자리까지 출력한다. 원의 넓이 = 반지름 * 반지름 * 원주율이다.)


입력 예
10
출력 예
314.00
 */
public class Main {

	public static void width(int half) {
		double widths=3.14*(double)(half*half);
		System.out.printf("%.2f",widths);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		width(num);
		
		sc.close();
	}

}
