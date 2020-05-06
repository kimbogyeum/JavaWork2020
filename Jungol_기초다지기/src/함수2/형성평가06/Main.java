package 함수2.형성평가06;

import java.util.Scanner;

/*
 * 자료의 개수 7을 매크로 상수로 정의하여 자료의 개수만큼 정수를 입력받아 입력받은 순서대로 앞에서부터 마지막까지 가면서 바로 뒤의 숫자와 비교하여 크면 교환한다. 이러한 작업을 세 번 반복한 후 그 결과를 하나의 행에 공백으로 구분하여 출력하는 프로그램을 작성하시오.


입력 예
15 20 41 8 26 33 19
출력 예
8 15 20 19 26 33 41
 */
public class Main {

	
	public static void Bubble(int arr[] ) {
		
		int temp;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	public static void main(String[] args) {
		
		final int DataNum=7;

		int []arr1=new int[DataNum];
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < arr1.length; i++) {
			arr1[i]=sc.nextInt();
		}
		
		Bubble(arr1);
		
		
		
		sc.close();
		
	}

}
