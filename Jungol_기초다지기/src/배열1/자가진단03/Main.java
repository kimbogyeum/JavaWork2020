package 배열1.자가진단03;

import java.util.Scanner;

/*
 * 10개의 문자를 입력받아서 첫 번째 네 번째 일곱 번째 입력받은 문자를 차례로 출력하는 프로그램을 작성하시오.
입력 예
A B C D E F G H I J
출력 예
A D G
 */
public class Main {
	public static void main(String[] args) {
		
		String [] a= new String [10] ;
		Scanner sc=new Scanner(System.in);
		
		for (int i = 0; i < a.length; i++) {
			a[i]=sc.next();
		}
		
	
		System.out.print(a[0]+" ");
		System.out.print(a[3]+" ");
		System.out.print(a[6]);

		sc.close();
		
	}

}
