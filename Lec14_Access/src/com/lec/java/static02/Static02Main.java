package com.lec.java.static02;

// ★ ★ ★클래스 변수 / 메소드 특징 (static) ★ ★ ★중요!!!
//1. 메모리의 '메소드 영역'에 클래스가 로드 될때(프로그램 시작될때) '한번만' 생긴다
//2. 인스턴스가 생성되지 않아도 사용할 수 있다.
//	 ★ ★ ★- 클래스이름.static변수,  클래스이름.static메소드()  <-- 요렇게 사용한다
//3. 모든 인스턴스는 하나의 static 변수/메소드를 '공유'한다.

// ★ ★ ★각 메모리에 update되는 순서와 구조  ★ ★ ★
//Method Area에 Test.sNum=123->999->500
//Heap에 Test=0->100 , Test=0->200
//stack에 t , t2
public class Static02Main {

	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드");
		
		//static 변수도 기본값으로 자동 초기화됨. 
		System.out.println(Test.sNum);//결과값: 0
		//무조건 "class이름 .변수"형태로 쓰기
		Test.show2();//이 역시 class이름.show2
		
		Test.sNum=123;
		Test.show2();
		
		//Test.num;//에러
		//인스턴스 변수 쓰려면 인스턴스를 먼저 생성해줘야함. 
		Test t=new Test();
		t.num=100;
		t.show();
		
		
		Test t2=new Test();
		t2.num=200;
		t2.show();
		
		Test.sNum=999;//num=200,sNum=999
		t2.show();
		t2.sNum=500;
		t.show();//num=100, sNum=500 마지막으로 update된 500이 출력된다. sNum은 오직 1개이다.
		
		Test.sNum=100;
		t.sNum=500;
		t2.sNum=700;
		System.out.println(Test.sNum);
		System.out.println(t.sNum);
		System.out.println(t2.sNum);//3개 전부다 700이 나와야지 마지막으로 update된게 700이니까
		
		

		
	} // end main()

} // end class Static02Main







