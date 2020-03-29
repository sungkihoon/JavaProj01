package ver07;

import java.util.*;

public class PhoneBookManager {

	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	int choice;

	public PhoneBookManager(int i) {
		// TODO Auto-generated constructor stub
	}

	public void printMenu() throws MenuSelectException{

		while(true) {
			try {
				System.out.println("선택하세요.");
				System.out.println("1. 데이터 입력");
				System.out.println("2. 데이터 검색");
				System.out.println("3. 데이터 삭제");
				System.out.println("4. 주소록 출력");
				System.out.println("5. 프로그램 종료");
				System.out.print("선택 : ");

				Scanner scan = new Scanner(System.in);

				int choice = scan.nextInt();
				System.out.println("입력한 숫자 : "+choice);

				if(choice>5||choice<1) {
					MenuSelectException menuSelectException
					= new MenuSelectException();
					throw menuSelectException;
				}
				scan.nextLine();

				switch(choice) {
				case MenuItem.INPUT:
					dataInput();
					break;
				case MenuItem.SEARCH:
					dataSearch();
					break;
				case MenuItem.DELETE:
					dataDelete();
					break;
				case MenuItem.SHOW:
					dataAllShow();
					break;
				case MenuItem.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				}

			}catch (MenuSelectException e) {
				System.out.println("1~5사이의 정수만 입력가능합니다.");
			}catch (InputMismatchException e) {
				System.out.println("정수만 입력가능합니다.");
			}catch (NullPointerException e) {
				System.out.println("검색된 결과가 없습니다.");
			}
		}
	}

	public void dataInput() throws MenuSelectException {

		//사용자로부터 친구정보를 입력받기 위한 준비
		Scanner scan = new Scanner(System.in);

		String name, phoneNumber, major, company, grade;
		try {
			System.out.println("데이터 입력을 시작합니다.");

			System.out.println("1.일반, 2.동창, 3.회사");
			System.out.print("선택 >> ");
			int inputNum = scan.nextInt();

			scan.nextLine();

			if(inputNum == SubMenuItem.NORMAL) {
				System.out.print("이름 : ");name = scan.nextLine();
				System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
				checkDouble(name);
				System.out.println("데이터 입력이 완료되었습니다.");

				PhoneInfo normal = new PhoneInfo(name,phoneNumber);
				set.add(normal); 
			}else if(inputNum == SubMenuItem.SC_FRIEND) {
				System.out.print("이름 : ");name = scan.nextLine();
				checkDouble(name);
				System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
				System.out.print("전공 : ");major = scan.nextLine();
				System.out.print("학년 : ");grade = scan.nextLine();

				System.out.println("데이터 입력이 완료되었습니다.");

				PhoneSchoolInfo school  = new PhoneSchoolInfo
						(name,phoneNumber,major,grade);
				set.add(school);
			}else if(inputNum == SubMenuItem.COMP_FRIENDS) {
				System.out.print("이름 : ");name = scan.nextLine();
				checkDouble(name);
				System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
				System.out.print("회사 : ");company = scan.nextLine();

				System.out.println("데이터 입력이 완료되었습니다.");

				PhoneCompanyInfo comp = new PhoneCompanyInfo
						(name, phoneNumber, company);
				set.add(comp);
			}
			MenuSelectException menuSelectException
			= new MenuSelectException();
			throw menuSelectException;

		}catch (MenuSelectException e) {
			System.out.println("1~3사이의 정수만 입력가능합니다.");
		}

	}

	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다.");
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchName = scan.nextLine();

		boolean find=false;
		boolean searchFlag = false;

		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = itr.next();
			if(searchName.equals(phoneInfo.name)) {
				System.out.println("요청하신 정보를 출력합니다.");
				searchFlag = true;
				System.out.println(phoneInfo);
				find = true;
			}
		}
		if(searchFlag == true) {
			System.out.println("요청하신 정보를 찾았습니다.");
		}else {
			System.out.println("검색결과가 없습니다.");
		}

		if(find==false) {
			NullPointerException ex = new NullPointerException();
			throw ex;
		}

	}

	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다.");
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : ");
		String deleteName = scan.nextLine();

		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = itr.next();
			if(deleteName.equals(phoneInfo.name)) {
				itr.remove();
			}
		}
	}

	public void dataAllShow() {
		System.out.println("주소록전체를 출력합니다.");
		for(PhoneInfo pi : set){
			System.out.println(pi.toString());
			System.out.println();
		}
		System.out.println("주소록 출력이 완료되었습니다.");
	}

	public void checkDouble(String name) throws MenuSelectException{
		Scanner scan = new Scanner(System.in);
		boolean check = false;
		int checkNum=0;

		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = itr.next();
			if(name.equals(phoneInfo.name)) {
				check = true;
			}
		}  
		if(check==true) {
			System.out.println("중복된 이름이 존재합니다. 덮어쓰시겠습니까?");
			System.out.println("1.덮어쓰기   2.메뉴로 돌아가기");
			checkNum = scan.nextInt();
			if(checkNum==1) {
				return;
			}else if(checkNum==2) {
				dataInput();
			}
		}else {
			return;
		}
	}
}
