package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.lec.java.collection03.Student;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		// Student 타입을 담는 ArrayList를 만드고
				ArrayList<MemberModel> list=new ArrayList<MemberModel>();
			
		// 사용자로부터 3개의 Student 데이터 을 입력받아서 id,password
				Scanner sc=new Scanner(System.in);
				for (int i = 0; i < 3; i++) {
					System.out.print("id입력: ");
					String id=sc.nextLine();
					System.out.println("passwd: ");
					String pw=sc.nextLine();
					

					MemberModel model=new MemberModel(id,pw);
					list.add(model);
				}
				sc.close();

//				Iterator<MemberModel> itr=list.iterator();
//				while(itr.hasNext()) {
//					itr.next().displayInfo();
//				}
//				
				for(MemberModel e:list) {
					e.displayInfo();
				}
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












