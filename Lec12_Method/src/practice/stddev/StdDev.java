package practice.stddev;


public class StdDev {

	public static void main(String[] args) {

		
		int arr[]= new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)(Math.random()*100+1);
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("평균:"+calcAvg(arr));
		System.out.println("분산:"+calcVariance(arr));
		System.out.println("표준편차: "+calcStdDev(arr));

		
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기

	} // end main
	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int [] arr) {
		double avg;
		int total=0;
		for (int i = 0; i < arr.length; i++) {
			total+=arr[i];
		}
		avg=total/5;
		return avg;
	}
	
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int [] arr) {
		double Var;
		double sum=0;
		double diff;
		for (int i = 0; i < arr.length; i++) {
			diff=arr[i]-calcAvg(arr);
			sum +=(diff*diff);
		}
		Var=sum/5;
		return Var;
	}
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int [] arr) {
		double sd;
		sd=Math.sqrt(calcVariance(arr));
		return sd;
	}

} // end class
