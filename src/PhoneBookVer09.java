import java.util.Scanner;

import ver03.*;

public class PhoneBookVer09 {

	public static void main(String[] args) {

		PhoneBookManager p3 = new PhoneBookManager(100);

		while(true) {
			p3.printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				p3.dataInput();
				break;
			case 2:
				p3.dataSearch();
				break;
			case 3:
				p3.dataDelete();
				break;
			case 4:
				p3.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}
}