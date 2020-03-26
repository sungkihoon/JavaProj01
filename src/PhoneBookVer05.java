import java.util.Scanner;

import ver05.MenuItem;
import ver05.PhoneBookManager;


public class PhoneBookVer05 {

	public static void main(String[] args) {

		PhoneBookManager p4 = new PhoneBookManager(100);

		while(true) {
			p4.printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			scan.nextLine();

			switch(choice) {
			case MenuItem.INPUT:
				p4.dataInput();
				break;
			case MenuItem.SEARCH:
				p4.dataSearch();
				break;
			case MenuItem.DELETE:
				p4.dataDelete();
				break;
			case MenuItem.SHOW:
				p4.dataAllShow();
				break;
			case MenuItem.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}