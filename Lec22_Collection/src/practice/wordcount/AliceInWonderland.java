package practice.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기//Collection11참고하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기//a 같은건 제외
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {
	
	

	public static void main(String[] args) {		
		System.out.println("실습: 단어 발생 빈도");
		String[]words=C.ALICE30.trim().toLowerCase().split("\\W+|\\_|\\t|\\n|\\d+|\\s+|\\r");
		//\\d+:  하나이상 연속된 숫자
		//\\W+: 한개 이상의 영문자와 숫자 그리고 밑줄 문자 이외의 문자
		//\\n,\\r: 줄바꿈 문자 
		//문자열에서 자른 문자를 빈도수와 함께 저장하는 인터페이스
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		List<word>word=new ArrayList<word>();
		
		//발생빈도 작성
		for (int i = 0; i < words.length; i++) { //words[i]가 key
			Integer v=hmap.get(words[i]);
			if(v==null) {
				hmap.put(words[i],1);
			}else {
				hmap.put(words[i], v+1);
			}
		}
		//결과 출력
		for (Map.Entry<String, Integer> e : hmap.entrySet()) {
			word.add(new word(e.getKey(), e.getValue()));
		}
		Collections.sort(word);
		for(word words1:word) {
			System.out.println(words1.word+":"+words1.count+"개");
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()
} // end class
	
class word implements Comparable<word>{
	String word;
	int count;
	
	public word() {
		super();
	}

	public word(String word,int count) {
		super();
		this.word=word;
		this.count=count;
	}
	
	@Override
	public int compareTo(word o) {
		//점수내림차순
		if(o.count<this.count) 
			return -1;
		if(o.count>this.count)
			return 1;
		return 0;
	}
}
	




