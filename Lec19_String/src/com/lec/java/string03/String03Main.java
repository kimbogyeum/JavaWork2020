package com.lec.java.string03;

/*  StringBuffer, StringBuilder

	 String 클래스는 immutable(변할 수 없는) 클래스이고,
	 StringBuffer, StringBuilder는 mutable 클래스임


	 StringBuffer:
		Java ver 1.0부터 있던 클래스
		쓰레드에 안전(thread-safe), 속도가 느림
	
	 StringBuilder:
		Java 5부터 생긴 클래스
		쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
	
		그 외에는 StringBuffer와 StringBuilder는 같은 기능(메소드)을 갖고 있음
		

	** 웹 프로그래밍 등에선 문자열을 '붙여 나가며' 완성하는 동작을 많이 함
		실무에서는
			String 을 concat() (혹은 + 연산)하기 보다는
			StringBuffer 를 append() 하는 것을 더 많이 사용함  (성능 UP)
			
		※ 그러나 학습예제에선 예제단순화를 위해 String 을 기본적으로 사용하니 참조 바랍니다
 */
public class String03Main {

	public static void main(String[] args) {
		System.out.println("[1] StringBuffer, StringBuilder");
		// String 클래스는 immutable 클래스이고,
		// StringBuffer, StringBuilder는 mutable 클래스임
		
		
		
		//String
		/*
		 * ----JVM의 구조----(String)
		 * M.A
		 * :String객체는 두개가 생긴다.
		 * String(0x100)--참조-->String("Hello")(문자열 그자체:immutable이므로 "HelloJava"가 되는건 아님)
		 * 
		 * Heap
		 * : String("HelloJava")(     )
		 * : String("HelloJava")(0x200)
		 * (처음에 단순히 할당안하고 concat한거였다가-->str1에 concat할당한걸로 바꿔서 이전거는 지워지고 새로이 생겨서 주소가 0x200으로 바뀐거임. )
		 * 
		 * Stack
		 * :str1(0x100),str2(0x100)=> 둘다 m.a의 String(literal)을 reference하는거지!
		 * :str1(0x200)(str1=str1.concat(str2))의 결과)
		 */
		System.out.println("[String: immutable]");

		String str1="Hello";
		String str2=str1;
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		
		if(str1==str2) {
			System.out.println("==동일참조");
		}else {
			System.out.println("==다른참조");
		}
		
		
		System.out.println(str1.concat("Java"));//HelloJava
		System.out.println("str1이 실제로 변경되지 않음: "+str1);//Hello M.A의 immutable"Hello"를 참조하고있으니까 concat로 변경되진 않지. 
		
		str1=str1.concat("Java");
		System.out.println("str1이 실제 변경됨: "+str1);
		
		if(str1==str2) {
			System.out.println("==동일참조");
		}else {
			System.out.println("==다른참조");
		}
		
		//StringBuffer
		/*
		 * ----JVM의 구조----(StringBuffer)
		 * M.A
		 * :
		 * 
		 * 
		 * Heap
		 * : StringBuffer("Hello")(0x100)<--buff1,buff2가 둘다 참조한다.
		 * : StringBuffer("HelloJava")(0x100)<--mutable이기 때문에 바로 HelloJava로 바뀌지
		 * 
		 * Stack
		 * :buff1(0x100),buff2(0x100)->buff1의 주소값이 그대로 들어가지
		 * 
		 * 
		 * => 실무에서는 String보다는 StringBuffer이 성능이 더 좋지. 
		 * => 왜냐하면 mutable이니까 immutable인 String처럼 Heap에 끊임없이 새로 만들어주는것보다 바로 바뀌는게 더나음.
		 */
		System.out.println();
		System.out.println("[StringBuffer: mutable]");
		
		StringBuffer buff1=new StringBuffer("Hello");
		StringBuffer buff2=buff1;
		
		System.out.println("buff1="+buff1);
		System.out.println("buff2="+buff2);
		
		if(buff1==buff2) {
			System.out.println("==동일참조");
		}else {
			System.out.println("==다른참조");
		}
		
		System.out.println(buff1.append("Java"));//buffer에서는 append로 한다.
		System.out.println(buff1);//String은 안바뀌었었는데 buff1은 바뀌네? 내부내용이 바뀐다는것. 
		
		if(buff1==buff2) {
			System.out.println("==동일참조");
		}else {
			System.out.println("==다른참조");
		}//동일참조네
		
		System.out.println(buff2);
		
		// StringBuffer:ex신호등이 있는 도로. 안전하지만 속도가 느림
		//  Java ver 1.0부터 있던 클래스
		//  쓰레드에 안전(thread-safe), 속도가 느림
		
		// StringBuilder:ex 신호등이 없는 도로.사고만 안난다면 속도가 빠름
		// Java 5부터 생긴 클래스
		// 쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
		
		// 그 외에는 StringBuffer와 StringBuilder는 같은 기능을 갖고 있음
		
		StringBuilder buff3=new StringBuilder("Hello");
		System.out.println(buff3.append("Java"));
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












