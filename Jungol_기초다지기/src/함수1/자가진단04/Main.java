package 함수1.자가진단04;

import java.util.Scanner;

/*
 * 세 개의 정수를 전달받아 최대값을 구하여 리턴하는 함수를 작성하고
세 정수를 입력받아 최대값을 출력하는 프로그램을 작성하시오.

입력 예
-10 115 33
출력 예
115

 */
public class Main {

	public static int Max(int num1,int num2,int num3) {
		int result1=0;
		result1=(num1>num2)? num1:num2;
		int result2=(num3>result1)? num3:result1;
		return result2;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num11,num22,num33=0;
		num11=sc.nextInt();
		num22=sc.nextInt();
		num33=sc.nextInt();

		int output=Max(num11,num22,num33);
		System.out.println(output);
		sc.close();

	}

}
