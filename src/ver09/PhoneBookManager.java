package ver09;

import java.util.Scanner;

public class PhoneBookManager {

	int choice;

	public PhoneBookManager(int size) {
	}

	public void printMenu() {
		while(true) {
			System.out.println("선택하세요.");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 주소록 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 : ");

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				dataInput();
				break;
			case 2:
				dataSearch();
				break;
			case 3:
				dataDelete();
				break;
			case 4:
				dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	public void dataInput() {
		new InsertQuery().execute();
	}

	public void dataSearch() {
		new SelectSQL().execute();
	}

	public void dataDelete() {
		new DeleteQuery().execute();
	}

	public void dataAllShow() {
		new SelectSQLall().execute();
	}
}
