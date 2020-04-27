package 반복제어문2.형성평가08;

import java.util.Scanner;

/*
 * 행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.
 
입력 예
3 4
출력 예
1 2 3 4
2 4 6 8
3 6 9 12
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		for (int i = 1; i < a + 1; i++) {
			for (int j = 1; j <= b; j++) {
				System.out.print((i * j) + " ");
			}
			System.out.println();
		}

		sc.close();

	}
}
