package 함수1.자가진단07;

import java.util.Scanner;

/*
 * 서로 다른 두 개의 정수가 주어진다.

두 정수를 입력받아 큰 수는 2로 나눈 몫을 저장하고 작은 수는 2를 곱하여 저장한 후 출력하는 프로그램을 작성하시오.

(참조에 의한 호출을 이용한 함수를 작성하여 값을 수정하고 출력은 메인함수에서 한다.)

입력 예
100 500
출력 예
200 250
 */
public class Main {
	
	public static int Rule1(int a, int b) {
		a=(a>b)? a/2:a*2;
		return a;
	}
	
	public static int Rule2(int a, int b) {
		b=(b>a)? b/2:b*2;
		return b;
	}

	public static void main(String[] args) {

		int num1,num2=0;
		Scanner sc=new Scanner(System.in);
			num1=sc.nextInt();
			num2=sc.nextInt();
			
			System.out.println(Rule1(num1, num2)+" "+Rule2(num1, num2));
			
		sc.close();
	}

}
