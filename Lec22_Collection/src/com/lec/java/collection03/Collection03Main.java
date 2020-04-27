package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		//TODO:
		// Student 타입을 담는 ArrayList를 만드고
		ArrayList<Student> list=new ArrayList<Student>();
		
		// 사용자로부터 3개의 Student 데이터 을 입력받아서 id,name,kor,eng,math
/*
		Student stu=new Student();
		Score score=new Score();
		stu.setId(100);
		stu.setName("김보겸");
		score.setEnglish(100);
		score.setKorean(90);
		score.setMath(100);
		
		for (int i = 0; i < list.size(); i++) {
			list[i]=
		}
*/
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("ID: ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("이름");
			String name=sc.next();
			System.out.println("국어, 영어, 수학:");
			int kor=sc.nextInt();
			int eng=sc.nextInt();
			int math=sc.nextInt();
			
			Student stu=new Student(id,name,new Score(kor,eng,math));
			list.add(stu);
		}
		sc.close();
		
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		for(Student e:list) {
			System.out.println(e);
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









