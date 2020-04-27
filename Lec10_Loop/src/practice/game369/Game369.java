package practice.game369;

public class Game369 {
	public static void main(String[] args) {

/*
		int i,j;
		for(i=1;i<100;i+=10) {
			for(j=0;j<10;j++) {
				String s= String.valueOf((i+j));
				String text= s.replace("3", "*");
				String text1= text.replace("6", "*");
				String text2= text1.replace("9", "*");
				
				System.out.print(text2+"\t");
			}
			System.out.println();
		}
*/
		System.out.println("369게임");
		int i;
		for(i=1;i<101;i++) {
			int x=i%10;
			int y=i/10;
			
			if((x==3||x==6||x==9) || (y==3||y==6||y==9)) {
				System.out.print("*"+"\t");
			}else {
				System.out.print(i+"\t");
			}
			if(i%10==0)
				
				System.out.println();
			
		}
			
	}
}
