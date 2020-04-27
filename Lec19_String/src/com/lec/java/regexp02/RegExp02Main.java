package com.lec.java.regexp02;

import java.util.regex.Matcher;//도우미 함수는 다시 해보기
import java.util.regex.Pattern;

/* 그룹(group) 
 * 정규표현식에 () 을 사용하여  패턴 내에서 '그룹'을 지정 하면
 * () 의 개수만큼 그룹이 만들어진다.
 */
public class RegExp02Main {

	public static void main(String[] args) {
		System.out.println("정규표현식 : group");
		
		String input;
		String regex;
		Pattern pat;
		Matcher matcher;
		
		System.out.println();
		regex = "(My)(....)";  // 정규표현식에 () 사용
		pat = Pattern.compile(regex);
		
		input = "-My98KK-myABCD--My1234567--MyZZ---My789";
		
		matcher = pat.matcher(input);
		
		System.out.println("groupCount():"+matcher.groupCount());
		System.out.println("입력문자열:"+input);
		while(matcher.find()) {
			System.out.println(matcher.group()+"{"+matcher.start()+"~"+matcher.end()+"}");
			
			//그룹들 출력해보기
			//group(int,group),start(int,group),end(int,group)
			System.out.println("\t group(0):"+matcher.group(0)+"{"+matcher.start(0)+"~"+matcher.end(0)+"}"); //(0)은 그룹 전체
			System.out.println("\t group(1):"+matcher.group(1)+"{"+matcher.start(1)+"~"+matcher.end(1)+"}");//(1)은 첫번째 그룹
			System.out.println("\t group(2):"+matcher.group(2)+"{"+matcher.start(2)+"~"+matcher.end(2)+"}");//(2)은 두번째 그룹
		}//end while
		
		// 도우미 함수를 사용해보자
		regExpTest("My....", "-My1234-");
		regExpTest("(My)(....)", "-My1234-");
		regExpTest("My....",input);
		regExpTest("(My)(....)",input);
		regExpTest("ABC...DEF", input);
		
		System.out.println("프로그램 종료");
	} // end main
	
	// 도우미 함수
	
	public static void regExpTest(String regex,String input) {
		System.out.println("[정규표현식 매칭 테스트]------------------------");
		System.out.println("정규표현식: "+regex);
		System.out.println("입력문자열: "+input);
		
		Matcher matcher=Pattern.compile(regex).matcher(input);
		int groupCount=matcher.groupCount();
		int matchCount=0;
		while(matcher.find()) {
			matchCount++;
			System.out.println("	매치"+matchCount+":"+matcher.group()+"{"+matcher.start()+"~"+matcher.end()+"}");
			if(groupCount>0) {
				for(int i=0;i<=groupCount;i++) {
					System.out.printf("\t group(%d):%s{%d~%d}\n",i,matcher.group(i),matcher.start(i),matcher.end(i));
				}
			}
		}//end while
		if(matchCount==0) {
			System.out.println("	X 매칭 없음 X");
			System.out.println();
		}
	}
	
} // end class

























