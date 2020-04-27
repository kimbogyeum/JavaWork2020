package com.lec.java.exception08;

import com.lec.java.exception07.ScoreException;

// TODO : Exception 상속받은 예외 클래스 만들기
public class AgeInputException extends Exception{
	//생성자
	public AgeInputException() {
		super("점수입력오류");
	}
	public AgeInputException(String age) {
		super(age);
		
	}

	
} // end class AgeInputException
