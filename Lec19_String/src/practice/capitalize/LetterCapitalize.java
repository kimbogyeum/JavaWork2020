package practice.capitalize;

import java.util.Scanner;
import java.util.StringTokenizer;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {
	
	// TODO : 필요한 메소드 있으면 추가
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		

		String[] words;
		while(true) {
			String input=sc.next();
			if(input.trim().equalsIgnoreCase("quit"))break;
			
			input=input.toLowerCase(); //소문자로 변환
			words=input.split("\\s+"); //공백 기준 단어 쪼개기
			for(String word:words) {
				if(word.length()>0) {
					String firstLetter=word.substring(0,1).toUpperCase();
					String rest=word.substring(1); //나머지 문자열
					System.out.print(firstLetter+rest+" ");//최종출력					
				}
			}
			System.out.println();
		}
		
		sc.close();
	} // end main()
} // end class
