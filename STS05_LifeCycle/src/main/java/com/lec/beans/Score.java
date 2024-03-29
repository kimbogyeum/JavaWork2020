package com.lec.beans;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Score implements InitializingBean, DisposableBean {

		int kor; //국어점수
		int eng; //영어점수
		int math; //수학점수
		String comment; //평가 코멘트

		
		

		public Score(){
			super();
			System.out.println("Score()생성");
		}
		
		public Score(int kor, int eng, int math, String comment) {
			super();
			System.out.printf("Score(%d,%d,%d,%s) 생성\n", kor, eng, math, comment);
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.comment = comment;
		}

		
		public Score(int [] arr) {
			System.out.printf("Score(%s) 생성\n",Arrays.toString(arr));
			this.kor=arr[0];
			this.eng=arr[1];
			this.math=arr[2];
		}

		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMath() {
			return math;
		}
		public void setMath(int math) {
			this.math = math;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}

		public void setScore(List<Integer> scores) {
			this.kor=scores.get(0);
			this.eng=scores.get(1);
			this.math=scores.get(2);
		}
		
		@Override
		public String toString() {
			return String.format("[Score 국어: %d 영어:%d 수학:%d 평가:%s ]", kor, eng, math, comment);
		}

		
		
		
		
		public void destroy() throws Exception {
			// bean 소멸 과정에서 호출
			System.out.println("빈 소멸 destroy() 호출");
		}

		
		public void afterPropertiesSet() throws Exception {
			// bean 초기화 하는 과정에서 호출
			System.out.println("빈 초기화 afterPropertiesSet() 호출");
			
		}
		
}
