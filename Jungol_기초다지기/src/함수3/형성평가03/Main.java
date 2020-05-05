package 함수3.형성평가03;

import java.util.Scanner;

/*
 * 자연수 N과 M을 입력받아서 주사위를 N번 던져서 나온 눈의 합이 M이 나올 수 있는 모든 경우를 출력하는 프로그램을 작성하시오. 단, N은 10 이하의 정수이다.

입력 예
3 10
출력 예
1 3 6
1 4 5
1 5 4
1 6 3
2 2 6
2 3 5
…
6 2 2
6 3 1
 */
public class Main {
	
	static int n;
	static int m;
	static int[] arr;
	
	public static void dice(int level, int sum) {
		
		if(level<arr.length) {
			for (int i = 1; i <7; i++) {
				arr[level]=i;
				dice(level+1,sum+i);
			}
		}else{
			if(sum==m) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[j]+" ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);

		n=sc.nextInt(); //level
		m=sc.nextInt(); //sum
		
		arr= new int[n];
		dice(0,0);
		
		
		
		
		sc.close();

	}

}
