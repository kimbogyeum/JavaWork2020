package 반복제어문1.자가진단04;

import java.util.Scanner;

/*
 정수를 계속 입력받다가 100 이상의 수가 입력이 되면 마지막 입력된 수를 포함하여 합계와 평균을 출력하는 프로그램을 작성하시오.

(평균은 반올림하여 소수 첫째자리까지 출력한다.)


입력 예
1 2 3 4 5 6 7 8 9 10 100
출력 예
155
14.1

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);		
		
		int input;
		int sum=0;
		int count=0;
		while(true) {
			input=sc.nextInt();
			sum+=input;
			count++;
			if(input>=100){
				double avg=(double)sum/count;
				System.out.println(sum);
				System.out.printf("%.1f",avg);
				break;
			}
			
		}
		sc.close();
		

	}

}
