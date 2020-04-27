package com.lec.java.collection07;

import java.util.HashSet;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// TODO
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		HashSet<String> set=new HashSet<String>();
		
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		set.add("김보겸");
		set.add("예채원");
		set.add("장지웅");
		set.add("노건훈");
		set.add("최현수");
		System.out.println(set.add("보겸아"));
		set.remove("김보겸");
		
		
		// iterator, enhanced-for 문을 사용해서 출력해보기
		for(String x:set) {
			System.out.println(x);
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















