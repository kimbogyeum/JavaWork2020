package 함수1.형성평가05;

import java.util.Scanner;

/*
 * 3명 학생의 3과목 점수를 입력받아 각 과목별 학생별 총점을 출력하는 구조화된 프로그램을 작성하시오.

입력 예
50 80 100
96 88 66
100 85 90
출력 예
50 80 100 230
96 88 66 250
100 85 90 275
246 253 256 755
 */
public class Main {


	public static void main(String[] args) {

		
		int arr[][]=new int[4][4];
		int sum=0;
		Scanner sc=new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j]=sc.nextInt();
				sum=sum+arr[i][j];
			}
			arr[i][3]=sum;
			sum=0;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum=sum+arr[j][i];
			}
			arr[3][i]=sum;
			sum=0;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		sc.close();

		
		
	}

}
