package 함수1.자가진단06;

import java.util.Scanner;

/*
 * 정수의 연산식을 입력받아 연산을 위한 함수를 호출하여

4칙연산(+ - * /)의 연산결과를 출력하는 프로그램을 작성하시오.
('/'의 경우는 정수 부분만 출력하고 4칙연산 이외의 연산 결과는 0으로 한다.)
( if_else 문으로 작성하세요.)

입력 예
10 + 20
출력 예
10 + 20 = 30
 */
public class Main {
	
	public static void Rule(int a,String b,int c) {
		int result;
		if(b.equals("+")) {
			result=a+c;
			System.out.println(a+" + "+c+" = "+result);
		}else if(b.equals("-")) {
			result=a-c;
			System.out.println(a+" - "+c+" = "+result);
		}else if(b.equals("*")) {
			result=a*c;
			System.out.println(a+" * "+c+" = "+result);
		}else if(b.equals("/")) {
			result=a/c;
			System.out.println(a+" / "+c+" = "+result);
		}else {
			result=0;
			System.out.println(a+" "+b+" "+c+" = "+result);
		}

		}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int input1=0,input2=0;
		String op="";
		
		input1=sc.nextInt();
		op=sc.next();
		input2=sc.nextInt();
		
		Rule(input1,op,input2);
		
		sc.close();
	}

}
