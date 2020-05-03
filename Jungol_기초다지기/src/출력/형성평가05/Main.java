package 출력.형성평가05;
/*
 * 다음 출력 예와 같이 모든 단어를 15칸씩 오른쪽에 맞추어 출력되는 프로그램을 작성하시오.


출력 예
          Seoul     10,312,545        +91,375
          Pusan      3,567,910         +5,868
        Incheon      2,758,296        +64,888
          Daegu      2,511,676        +17,230
        Gwangju      1,454,636        +29,774

 */
public class Main {

	public static void main(String[] args) {

		System.out.printf("%15s%15s%15s\n","Seoul","10,312,545","+91,375");
		System.out.printf("%15s%15s%15s\n","Pusan","3,567,910","+5,868");
		System.out.printf("%15s%15s%15s\n","Incheon","2,758,296","+64,888");
		System.out.printf("%15s%15s%15s\n","Daegu","2,511,676","+17,230");
		System.out.printf("%15s%15s%15s\n","Gwangju","1,454,636","+29,774");

		
	
	}

}
