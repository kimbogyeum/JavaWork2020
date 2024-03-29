package com.lec.java.string02;

/* String 생성자, String literal(상수)
 * 
 * ----JVM의 구조----
 * M.A
 * :String("Hello")(0x100)//리터럴은 하나만 생긴다.그래서 String이 두개생겼지만 하나만!
 * 
 * Heap
 * :String(0x200)//m.a의 String("Hello")를 내부적으로 reference
 * :String(0x300)<=str4가 reference하겠지?//이것도 m.a의 String("Hello")를 참조하지.
 * 
 * Stack
 * :str1(0x100),str2(0x100)=> 둘다 m.a의 String(literal)을 reference하는거지!
 * :str3(0x200), str4(0x300)
 */
public class String02Main {

	public static void main(String[] args) {
		System.out.println("String 생성자, literal(상수)");
		
		int num1 = 1;
		int num2 = 1;
		
		if (num1 == num2) {
			System.out
			.println("같은 숫자");
		} else {
			System.out.println("다른 숫자");
		}
		
		System.out.println();
		System.out.println("[1] String literal 사용");
		// "Hello"는 literal이기 때문에, 한 번 만들어지면 재사용됨
		// 그래서, str1과 str2는 같은 곳(주소)에 있는 문자열 "Hello"를 가리키게 됨
		// 즉, str1과 str2에는 같은 값이 저장되게 됨
		String str1 = "Hello";   
		String str2 = "Hello";

		
		if(str1==str2) {//문자열은 ==으로 비교할 수 없음. 이거는 주소를 비교한것이다. 
			System.out.println("동일한곳(문자열)참조");
		}else {
			System.out.println("다른곳(문자열)참조");
		}
		
				
		
		
		System.out.println();
		System.out.println("[2] String 생성자 사용");
		/* 생성자는 호출될 때마다 새로운 인스턴스를 힙에 생성하게 됨
		 * str3과 str4는 서로 다른 인스턴스를 가리키게 됨
		 * 즉, str3과 str4에는 서로 다른 값이 저장되게 됨
		 */
		String str3 = new String("Hello");
		String str4 = new String("Hello");

		if(str3==str4) {//이거는 주소를 비교한것이다. 그래서 다르게나오지.
			System.out.println("동일한곳(문자열)참조");
		}else {
			System.out.println("다른곳(문자열)참조");
		}
		
		
		System.out.println();
		System.out.println("[2-2] String intern()결과비교");
		//intern() String 객체가 실제로 참조하는 문자열 리턴
		//그럼 이경우에는 str1,2,3,4가 전부 String("Hello")라는 동일한 literal을 참조하고있으니까!
		if(str1.intern()==str4.intern()) {
			System.out.println("intern()동일한 (문자열)참조");
		}else {
			System.out.println("intern()다른곳(문자열)참조");
		}
		
		
		
		// == 연산자는 실제 문자열이 같은 지 다른 지를 비교하는 것이 아니고,
		// 참조 변수(지역 변수) str3과 str4에 저장된 값(주소)가  같은 지 다른 지를 비교하는 것임.
		// 문자열 비교를 == 으로 하지 말것!!!!
				
		
		System.out.println();
		System.out.println("[3] String equals() 메소드");
		// 문자열 비교는 equals() 사용하자.  참고로 equals() 는 Object 의 메소드다.

		if(str3.equals(str4)) {//실제 문자열을 비교한다. 
			System.out.println("equals()같은 문자열");
		}else {
			System.out.println("equals()다른 문자열");
		}
		
		
		System.out.println();
		System.out.println("[4] String compareTo() 메소드");
		// compareTo() 는 두 문자열의 문자코드량 의 비교 (lexicographical comparison based on the Unicode value)
		// 이경우 유니코드 값을 비교하게 됨.
		System.out.println("compareTo:"+str3.compareTo(str4));
		
		
		String str5 = "A";
		String str6 = "C";
		
		System.out.println("compareTo:"+str5.compareTo(str6));//A-C
		System.out.println("compareTo:"+str6.compareTo(str5));//C-A
		
		str5 = "AaAa";
		str6 = "aAaA";
		
		
		System.out.println("compareTo:"+str5.compareTo(str6));//A-a 순서상 A가 a보다 먼저나와서 답은 음수 //-32
		System.out.println("compareTo:"+str6.compareTo(str5));//a-A //+32
		
		str5 = "xaAa";
		str6 = "xAaA";
		
		System.out.println("compareTo:"+str5.compareTo(str6));//A-a 순서상 A가 a보다 먼저나와서 답은 음수// +32
		System.out.println("compareTo:"+str6.compareTo(str5));//a-A //-32

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











