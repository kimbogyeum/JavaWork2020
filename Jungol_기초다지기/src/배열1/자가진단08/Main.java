package 배열1.자가진단08;
/*10개의 정수를 입력받아 배열에 저장한 후 짝수 번째 입력된 값의 합과 홀수 번째 입력된 값의 평균을 출력하는 프로그램을 작성하시오.
평균은 반올림하여 소수첫째자리까지 출력한다.


입력 예
95 100 88 65 76 89 58 93 77 99
출력 예
sum : 446
avg : 78.8

*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		int[]arr=new int[10];
		
		Scanner sc=new Scanner(System.in);
		
		int sum=0;
		double sum2=0;
		double avg=0;
		for (int i = 0; i <arr.length; i++) {
			arr[i]=sc.nextInt();
			if((i+1)%2==0) {
				sum=sum+arr[i];
			}else {
				sum2=sum2+arr[i];
				avg=sum2/5;
			}
		}
		
		System.out.println("sum : "+ sum);
		System.out.println("avg : "+ String.format("%.1f", avg));
		
		sc.close();
		
	}

}
