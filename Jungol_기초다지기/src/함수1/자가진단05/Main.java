package 함수1.자가진단05;

import java.util.Scanner;

/*
 * 10 이하의 두 정수가 주어진다.

이를 입력 받아서 첫 번째 수를 두 번째 수만큼 거듭제곱하여 나온 값을 리턴하는 함수를 작성하여 

다음과 같이 출력하는 프로그램을 작성하시오.


입력 예
2 10
출력 예
1024
 */
public class Main {

	public static int square(int num1, int num2) {
		int result=(int)Math.pow(num1, num2);
		return result;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int a=0, b=0;
		
		if(a <11|| b<11) {
		a=sc.nextInt();
		b=sc.nextInt();
		int result=square(a, b);
		System.out.println(result);
		}
		
		sc.close();

	}

}
