package 선택제어문.자가진단09;

import java.util.Scanner;

/*
 * 3개의 정수를 입력받아 조건연산자를 이용하여 입력받은 수들 중 최소값을 출력하는 프로그램을 작성하시오.
 * 
입력 예
18 -5 10

출력 예
-5
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int array[]=new int[3];
		for (int i = 0; i < array.length; i++) {
			array[i]=sc.nextInt();
		}
		sc.close();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1; j++) {
				if (array[j]>array[j+1]) {
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]= temp;
				}
			
			}
			
		}
		System.out.println(array[0]);

	}

}
