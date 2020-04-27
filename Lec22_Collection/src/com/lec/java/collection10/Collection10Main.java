package com.lec.java.collection10;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		TreeSet<String>tset=new TreeSet<String>();
		// 5개 이상의 데이터를 저장해보고
		tset.add("abc");
		tset.add("def");
		tset.add("ghi");
		tset.add("jkl");
		tset.add("mno");
		
		// 오름차순, 내림차순으로 출력해보기
		//오름차순
		Iterator<String> itr=tset.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		
		//내림차순
		Iterator<String>itr2=tset.descendingIterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
		//enhanced for
		System.out.println();
		System.out.println("enhanced for");
		for(String s:tset) {
			System.out.println(s);
		}
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

















