package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;



public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		ArrayList<String> list1=new ArrayList<String>();
		// 5개 이상의 String을 저장하고
		list1.add("김");
		list1.add("보");
		list1.add("겸");
		list1.add("안");
		list1.add("롱");
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		list1.set(1, "윤");
		list1.set(3, "메");
		list1.remove(0);
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("for: "+list1.get(i));
		}

		//Enhanced-for
		for(String s:list1) {
			System.out.println("Enhance-for: "+s);
		}
		
		//Iterator
		Iterator<String> itr=list1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












