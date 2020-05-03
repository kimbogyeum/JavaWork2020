package 함수1.자가진단08;

import java.util.Scanner;

/*
 * 10 이하의 두 개의 정수를 입력받아서 작은 수부터 큰 수까지의 구구단을 차례대로 출력하는 프로그램을 구조화하여 작성하시오.

입력 예
3 5
출력 예
== 3dan ==
3 * 1 =  3
3 * 2 =  6
3 * 3 =  9
3 * 4 = 12
3 * 5 = 15
3 * 6 = 18
3 * 7 = 21
3 * 8 = 24
3 * 9 = 27

== 4dan ==
4 * 1 =  4
4 * 2 =  8
4 * 3 = 12
 … 
5 * 8 = 40 
5 * 9 = 45
 */
public class Main {

	public static void gugu(int a, int b) {
		for (int i = a; i <b+1; i++) {
			System.out.println("== "+i+"dan"+" ==");
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %2d\n",i,j,(i*j));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int num1 = 0, num2=0;
		num1=sc.nextInt();
		num2=sc.nextInt();
		gugu(num1,num2);
		
		sc.close();
	}

}
