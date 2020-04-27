package my.prac;

import java.util.ArrayList;
import java.util.Scanner;

public class My_prac01 {

	public static void main(String[] args) {
		// Student 타입을 담는 ArrayList를 만드고
		ArrayList<Student> list=new ArrayList<Student>();
		// 사용자로부터 3개의 Student 데이터 을 입력받아서 id,name,kor,eng,math

		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("ID: ");
			int id=sc.nextInt();
			System.out.println("이름: ");
			String name=sc.next();
			System.out.println("국어, 영어, 수학:");
			int kor=sc.nextInt();
			int eng=sc.nextInt();
			int math=sc.nextInt();
			
			Student stu=new Student(id,name,new Score(kor,eng,math));
			
		}
		sc.close();
	}

}
