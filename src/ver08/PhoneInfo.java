package ver08;

import java.io.Serializable;
import java.util.Scanner;

public class PhoneInfo implements Serializable {

	//멤버변수
	String name;
	String phoneNumber;

	//생성자
	public PhoneInfo(String name, String phoneNumber ) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "이름 : "+name+"\n전화번호 : "+phoneNumber;
	}
	
	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		int hc2 = name.hashCode();
		int hc3 = name.hashCode();
		int result = hc1+hc2+hc3;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneInfo = (PhoneInfo)obj;
		if(phoneInfo.name.equals(this.name)) {
			return true;
		}else return false;
	}
	
	
	public PhoneInfo() {}

	public void Insert() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 프로그램 종료");
			System.out.print("선택 : ");
			int choice = scan.nextInt();
			scan.nextLine();

			if(choice==1) {
				System.out.print("이름 : ");
				name = scan.nextLine();
				System.out.print("전화번호 : ");
				phoneNumber = scan.nextLine();

				System.out.println();
				System.out.println("입력된 정보 출력...");
				showPhoneInfo();
				System.out.println();
				
			}else if(choice==2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println();
			}
		}
	}

	//정보출력용 메소드
	public void showPhoneInfo(){
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
	}
	
}
