package 배열2.형성평가02;

import java.util.Scanner;

/*
 * 승지는 주사위 놀이를 하다가 주사위를 10번 던져서 각 숫자가 몇 번씩 나왔는지 알아보려고 한다. 한번 던질 때마다 나온 주사위의 숫자를 입력받아서 각 숫자가 몇 번씩 나왔는지 출력하는 프로그램을 작성하시오.


입력 예
5 6 3 4 5 5 2 2 4 6
출력 예
1 : 0
2 : 2
3 : 1
4 : 2
5 : 3
6 : 2
 */
public class Main {
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int arr[]=new int[10];
		int cnt1=0;
		int cnt2=0;
		int cnt3=0;
		int cnt4=0;
		int cnt5=0;
		int cnt6=0;

		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		
			switch(arr[i]) {
			
			case 1:
				cnt1++;
				break;
			case 2:
				cnt2++;
				break;
			case 3:
				cnt3++;
				break;
			case 4:
				cnt4++;
				break;
			case 5:
				cnt5++;
				break;
			case 6:
				cnt6++;
				break;
			}
			
		}
		System.out.println("1 : "+cnt1);
		System.out.println("2 : "+cnt2);
		System.out.println("3 : "+cnt3);
		System.out.println("4 : "+cnt4);
		System.out.println("5 : "+cnt5);
		System.out.println("6 : "+cnt6);
		
		
		
		
		
		
		sc.close();
		
		
	}

}
