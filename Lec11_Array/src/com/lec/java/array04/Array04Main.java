package com.lec.java.array04;



import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		

		//int형의 길이는 5개인 배열을 score라는 이름으로 선언
		int[] score=new int[5];
		int total=0;
		//키보드로 입력받아서 원소 5개 초기화
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수입력: ");
			score[i]=sc.nextInt();
			total+=score[i];
		}
		sc.close();
		
			System.out.println("총점: "+total);
			System.out.println("평균: "+(double)total/score.length);
			
			System.out.println();
			//최댓값
			int max=score[0];
			for (int i = 1; i < score.length; i++) {
				if(score[i]>max) {
					max=score[i];
				}
			}
			System.out.println("최댓값= "+max);
			
			//최소값
			int min=score[0];
			for (int i = 1; i < score.length; i++) {
				if(score[i]<min) {
					min=score[i];
				}
//				min=(score[i]<min) ? score[i]:min; // 3항 연산자? 로도 만들어보기 
			}
			System.out.println("최소값= "+min);
			
			
		
		
		
			
	} // end main()

} // end class Array04Main







