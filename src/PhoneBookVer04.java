import java.util.Scanner;
import ver04.PhoneBookManager;


public class PhoneBookVer04 {

	public static void main(String[] args) {

		PhoneBookManager p4 = new PhoneBookManager(100);

		while(true) {
			p4.printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			scan.nextLine();

			switch(choice) {
			case 1:
				p4.dataInput();
				break;
			case 2:
				p4.dataSearch();
				break;
			case 3:
				p4.dataDelete();
				break;
			case 4:
				p4.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}
}