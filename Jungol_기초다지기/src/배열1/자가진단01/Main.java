package 배열1.자가진단01;
/*
 * 문자 10개를 저장할 수 있는 배열을 만들고 10개의 문자를 입력받아 입력받은 문자를 이어서 출력하는 프로그램을 작성하시오.
 * 입력 예
A B C D E F G H I J
출력 예
ABCDEFGHIJ
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String a;
		Scanner sc=new Scanner(System.in);
		a=sc.nextLine();
		for (int i = 0; i < 20; i+=2) {
			
			System.out.printf("%c",a.charAt(i));
			
		}
		
		

	}

}
