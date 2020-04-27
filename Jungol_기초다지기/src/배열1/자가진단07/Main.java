package 배열1.자가진단07;

import java.util.Scanner;

/*
 * 10개의 정수를 입력받아 100 미만의 수 중 가장 큰 수와 100 이상의 수 중 가장 작은 수를 출력하는 프로그램을 작성하시오.

(입력되는 정수의 범위는 1이상 10,000 미만이다. 만약 해당하는 수가 없을 때에는 100 을 출력한다.)


입력 예
88 123 659 15 443 1 99 313 105 48
출력 예
99 105
 */
public class Main {

	public static void main(String[] args) {
		int [] input= new int[10];
		int max=10000;
		int min=0;
		int num;
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < input.length; i++) {
			input[i]=sc.nextInt();
			
			if(input[i]>=100 && input[i]<max) {
				max=input[i];
			}else if(input[i]>min && input[i]<100) {
				 min=input[i];
			}
		}
		if(max==10000) {
			max=100;
		}else if(min==1) {
			min=100;
		}
		
		System.out.println(min+" "+max);
		sc.close();
		

	}

}
