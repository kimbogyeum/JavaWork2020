package com.lec.java.static03;

import java.util.Calendar;

//Singleton 디자인 패턴
//생성되는 인스턴스가 최대 1개까지만 허용해야하는 패턴설계

//★ ★ ★각 메모리에 update되는 순서와 구조  ★ ★ ★
//Method Area에 Test.count=0 , Test.instance=null
//Heap에 Test instance= num 0->123
//stack에 t1 , t2
public class Static03Main {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");
		
		//생성자 못만들게 하려면 Test 생성자를 private로 바꾸기
		//Test t1=new Test();
		//Test t2=new Test();
		
		Test t1=Test.getInstance();
		System.out.println("t1.num="+t1.getNum());
		t1.setNum(123);
		System.out.println("t1.num="+t1.getNum());
		
		Test t2=Test.getInstance();
		System.out.println("t2:num= "+t2.getNum());//0이 아닌 123이 나오는걸 알아야지.
		t2.setNum(500);
		System.out.println("t1:num=" + t1.getNum());
		
		//Singleton 사용 예
		//Calendar c=new Calendar; -> 생성자 지원 x
		Calendar c=Calendar.getInstance();
		
		
		
	} // end main()

} // end class Static03Main











