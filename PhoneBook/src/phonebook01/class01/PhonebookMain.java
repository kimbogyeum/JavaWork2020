package phonebook01.class01;

import java.util.Scanner;


public class PhonebookMain {

	Scanner sc;
	PhonebookModel[]bookData= new PhonebookModel[5];
	//PhonebookModel은 reference type이라서 주소를 나타내는것이야.여기에 데이터를 넣으려고 하면 안되지.
	
	public static void main(String[] args) {
		PhonebookMain app=new PhonebookMain();//app은 reference type이니까 주소를 남기지
		app.init();//초기화
		app.run();//실행
		app.exit();//종료
	}//end main
	
	
	//응용프로그램 초기화
	
	public void init() {
		sc=new Scanner(System.in);
	}
	
	//응용프로그램 구동
	public void run() {
		System.out.println("전화번호부 v1.0");
		while(true) {
			showMenu();//메뉴표시
			
			int menu=sc.nextInt();
			sc.nextLine();//메뉴입력
			
			switch(menu) {
			case 1:
				System.out.println("전화번호부를 입력합니다.");
				insertPhoneBook();
				break;
			case 2:
				System.out.println("전화번호부 출력(열람)");
				showPhoneBook();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}//end while
	}//end run
	
	
	
	//응용프로그램 종료
	public void exit() {
		sc.close();//프로그램 종료할때 Scanner도 끝나야지
	}
	
	//전화번호부 입력
	public void insertPhoneBook() {
		// 전화번호부가 다 찼는지 체크
		int i;
		for (i = 0; i < bookData.length; i++) {
			if (bookData[i] == null)
				break;
		}
		if (i == bookData.length) {
			System.out.println("전화번호부가 다 찼습니다.");
		}
		// 다 찼으면 입력불가 처리
		
		
		// 이름, 전화번호, 이메일입력
		System.out.println("이름입력");
		String name = sc.nextLine();
		
		System.out.println("전화번호입력");
		String phoneNum = sc.nextLine();
		
		System.out.println("이메일입력");
		String email = sc.nextLine();
		
		// --> PhonebookModel 인스턴스 생성
		PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
		pb.setUid(i);
		
		//배열에 추가
		bookData[i]=pb;
		System.out.println((i+1)+"번쨰 전화번호부 추가 성공");
	}
	
	// 전화번호부 출력
	public void showPhoneBook() {
		int i;
		for (i = 0; i < bookData.length; i++) {
			PhonebookModel pb = bookData[i];
			if (pb == null)
				break;

			System.out.println(pb);
		}
		System.out.println();
	}
	
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 종료");
		System.out.println("------------------");
		System.out.print("선택: ");
	}


}//end class
