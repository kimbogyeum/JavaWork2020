package com.lec.java.wrapper05;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다.
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 */
public class Wrapper05Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");
		
		Object[] obj=new Object[5];//object 최고조상
		obj[0]=new Wrapper05Main();
		obj[1]=new A();
		obj[2]=new A2();
		obj[3]=new B();
		obj[4]=123; //primitive타입이 object타입에 들어간다고?==>Object가 Primitive type도 받을 수 있다.
		//그이유는 auto-boxing+Polymorphism(다형성)
		//Object<--polymorphism--Integer<--autoboxing--int
		
		for(Object e:obj) {
			System.out.println(e);
		}//마지막에 123은 Wrapper class가 자동적으로 auto-unboxing까지 해준것이여
		
		
		System.out.println();
		
		//실타입이 Object면 auto-unboxing 등이 필요한 연산식에서는 형변환을 해줘야한다. 
//		int num=obj[4]*3;//에러! object에 곱하기는 안되지
		int num=(Integer)obj[4]*3;//형변환 해주면 되지
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

	
	
} // end class

class A{}
class A2 extends A{}
class B{}
