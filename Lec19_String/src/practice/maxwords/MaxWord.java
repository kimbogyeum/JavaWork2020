package practice.maxwords;


import java.util.Scanner;
import java.util.StringTokenizer;
/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {
	

	public static void main(String[] args) {
		int count=0;
		String text="";
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();

		StringTokenizer token = new StringTokenizer(str, ".!?");

		while (token.hasMoreTokens()) {
			
				String arr = token.nextToken().trim();	
				String[] arr1=arr.split("\\s+");
				
				if(arr1.length>=count) {
					count=arr1.length;
					text=arr;
				}

		}
		
		System.out.println(count+"개");
		System.out.println(text);
		
		
		
	} // end main
} // end class
