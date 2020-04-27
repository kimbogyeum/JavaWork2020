package com.lec.java.exception04;

/*	예외 클래스의 상속 관계 (★필수 암기★)
	java.lang.Object
	|__ java.lang.Throwable
	  |
	  |__ java.lang.Exception  : 복구 가능
	  |    |
	  |    |__ java.lang.RuntimeException
	  |    |    |__ ArithmeticException, NullPointerException, ...-> 반드시 코드적인 처리를 할 필요없다. 
	  |    |
	  |    |__ IOException, ParseException ...->반드시 핸들링 해줘야한다. 코드상으로 반드시 해줘야한다.
	  |
	  |__ java.lang.Error    : 복구 불가
	         ...   OutOfMemoryError, StackOverFlowError ...  
	
	 getMessage(), printStackTrace() 등의 메소드는 Throwable 클래스에 정의
	 자식 클래스들은 Throwable에 정의된 메소드들을 사용할 수 있음
	 
	catch문은 여러개를 사용할 수는 있지만, 
	 상위 예외 클래스를 하위 예외 클래스보다 먼저 사용할 수는 없다. (컴파일 에러) 
*/
public class Exception04Main {

	
	public static void main(String[] args) {
		System.out.println("try ~ catch ~ catch ");

		int num1 = 123, num2 = 10, result = 0;
		String str = "abcd";
		int[] numbers = new int[10];

		// TODO : try ~ catch ~ catch .. 사용
		try {

			result = num1 / num2;
			System.out.println("나눈 결과: " + result);

			int length = str.length();
			System.out.println("스트링 길이: " + length);

			str.charAt(20);//20번째 글자는 뭘까 StringIndexOutOfBoundsException;
			
			numbers[9] = 11111;
			System.out.println("numbers: " + numbers[10]);
			
		
		}catch (ArithmeticException ex) {
			System.out.println("산술 연산 예외:" + ex.getMessage());
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("배열 인덱스 예외:" + ex.getMessage());
		} catch (NullPointerException ex) {
			System.out.println("null 포인터:" + ex.getMessage());
		}catch(Exception e) {//어떠한 Exception이 발생해도 다잡음
			System.out.println("Exception 발생");
			// Exception 은 모~든 Exception 들 (상속된 예외 객체들까지도) catch 할수 있다.
			// (다형성!)
		}

		
		//num2에서 0을 10으로 바꾸면 length에서 에러가 나겠지-> catch문에서도 null포인터 에러가 나겠지
		//str을 null에서 "abcd"로 바꾸고 20번째 글자를 찾아보면 StringIndexOutOfBoundsException발생,but catch문에 없으니 죽음.
		//Exception e를  catch맨 위로 올리면 밑에 캐치절에 갈 수 없어서 구조적으로 말이 안됨. unreachable catchblock
		
		System.out.println();
		System.out.println("프로그램 종료");

	} // end main()

	
} // end class Exception04Main












