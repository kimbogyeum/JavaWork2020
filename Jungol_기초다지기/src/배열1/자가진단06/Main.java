package 배열1.자가진단06;
/*
 * 10개의 정수를 입력받아 그 중 가장 작은 수를 출력하는 프로그램을 작성하시오.(입력받을 정수는 1000을 넘지 않는다.)


입력 예


출력 예
2
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int [] arr= new int[10];
		int num=0;
		int min=1000;
		
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			num=sc.nextInt();
			if(num<min) min=num;
		}
		System.out.println(min);
		

	}

}
