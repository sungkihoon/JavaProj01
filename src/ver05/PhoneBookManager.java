package ver05;

import java.util.Scanner;

public class PhoneBookManager {

	private PhoneInfo[] dataArray;
	int numofArray, choice;

	public PhoneBookManager(int size) {
		dataArray = new PhoneInfo[size];
		numofArray=0;
	}

	public void printMenu() {
		System.out.println("선택하세요.");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public void dataInput() {

		//사용자로부터 친구정보를 입력받기 위한 준비
		Scanner scan = new Scanner(System.in);

		String name, phoneNumber, major, company;
		int grade;
		System.out.println("데이터 입력을 시작합니다.");

		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.print("선택 >> ");
		int inputNum = scan.nextInt();
		scan.nextLine();

		if(inputNum == SubMenuItem.NORMAL) {
			System.out.print("이름 : ");name = scan.nextLine();
			System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
			System.out.println("데이터 입력이 완료되었습니다.");

			PhoneInfo p3 = new PhoneInfo(name,phoneNumber);
			dataArray[numofArray++] = p3; 
		}else if(inputNum == SubMenuItem.SC_FRIEND) {
			System.out.print("이름 : ");name = scan.nextLine();
			System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
			System.out.print("전공 : ");major = scan.nextLine();
			System.out.print("학년 : ");grade = scan.nextInt();

			System.out.println("데이터 입력이 완료되었습니다.");

			PhoneSchoolInfo school  = new PhoneSchoolInfo
					(name,phoneNumber,major,grade);
			dataArray[numofArray++] = school; 
		}else if(inputNum == SubMenuItem.COMP_FRIENDS) {
			System.out.print("이름 : ");name = scan.nextLine();
			System.out.print("전화번호 : ");phoneNumber = scan.nextLine();
			System.out.print("회사 : ");company = scan.nextLine();

			System.out.println("데이터 입력이 완료되었습니다.");

			PhoneCompanyInfo comp  = new PhoneCompanyInfo
					(name, phoneNumber, company);
					dataArray[numofArray++] = comp; 
		}



	}

	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다.");
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요 : ");
		String searchName = scan.nextLine();

		for(int i=0;i<numofArray;i++) {

			if(searchName.compareTo(dataArray[i].name)==00) {
				dataArray[i].showPhoneInfo();

				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
			}
		}
	}

	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다.");
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : ");
		String deleteName = scan.nextLine();

		int deleteIndex = -1;

		for(int i=0;i<numofArray;i++) {
			if(deleteName.compareTo(dataArray[i].name)==00) {
				//요소를 삭제하기 위해 참조값을 null로 변경
				dataArray[i] = null;
				//삭제된 요소의 인덱스값 저장
				deleteIndex = i;
				//전체카운트 변수 -1차감
				numofArray--;
			}
		}

		if(deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다.==");
		}
		else {
			/*
			 객체배열에서 검색된 요소를 삭제한 후 입력된 위치의 바로 뒤 요소를
			 앞으로 하나씩 교환한다
			 */
			for(int i=deleteIndex;i<numofArray;i++) {
				dataArray[i] = dataArray[i+1];
			}
		}
		System.out.println("데이터 삭제가 완료되었습니다.");
	}

	public void dataAllShow() {
		System.out.println("주소록전체를 출력합니다.");
		for(int i=0; i< numofArray ; i++) {
			dataArray[i].showPhoneInfo();
			System.out.println();
		}
		System.out.println("주소록 출력이 완료되었습니다.");
	}
}
