package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {
		//3개의 열로 출력되도록 해보자
		
		for(int i=2;i<=6;i+=3) {
			System.out.printf("%d단\t\t%d단\t\t %d단", i, i + 1, i + 2);
			System.out.println();
			for (int j = 1; j <= 9; j++) {
				for (int n = i; n < i + 3; n++) {
					System.out.print(n + " x " + j + " = " + (n * j) + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}

		System.out.printf("%d단\t\t%d단", 8, 9);
		System.out.println();
		for (int j = 1; j <= 9; j += 1) {
			for (int i = 8; i <= 9; i++) {
				System.out.print(i + " x " + j + " = " + (i * j) + "\t");
			}
			System.out.println();
		}
			
		

	}//end main
}//end class
