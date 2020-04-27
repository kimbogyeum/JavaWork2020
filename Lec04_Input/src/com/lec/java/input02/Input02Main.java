package com.lec.java.input02;

import java.util.Scanner; // 단축키: ctrl+shift+O

//문자열(String)입력
//char
public class Input02Main {

	public static void main(String[] args) {
		System.out.println("표준입력: String, char");
		
		Scanner sc=new Scanner(System.in); //scanner객체 생성 

/*		//String 입력
		System.out.print("이름을 입력하세요: ");
		String name=sc.nextLine(); //엔터를 입력할때까지의 모든 문자들을 문자열로 리턴
		
		System.out.print("별명을 입력하세요: ");
		String nick=sc.nextLine();
		
//		System.out.println("이름은"+name +"\n"+ "별명은"+ nick);
		
		
		
		//char 입력
		// .nextChar()?라는 명령 없다!
		System.out.print("성별을 입력하세요 m/f: ");
		char gender=sc.next().charAt(0);
		System.out.println("이름은"+name +"\n"+ "별명은"+ nick+"성별은"+gender);
		
		
		System.out.println();
*/
		
		
		
		System.out.println("나이를 입력하세요: ");
		int age=sc.nextInt();
		
		System.out.println("주소도 입력하세요: ");
		
		//숫자 입력 받은 뒤에 문자열 입력시에는 반드시 '\n'을 consume(버퍼에서 제거)해야한다. 
		sc.nextLine();
		
		String addr=sc.nextLine();
		
		System.out.println("나이: "+age+"\n주소: "+addr);
		
		
		
		
		
		
		sc.close();
		

	}

}
