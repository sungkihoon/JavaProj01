package ver08;

public class PhoneSchoolInfo extends PhoneInfo{
	String major;
	String grade;
	public PhoneSchoolInfo(String name, 
			String phoneNumber, String major, String grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+grade);
	}
	
	@Override
	public String toString() {
		return "이름 : "+name+"\n전화번호 : "+phoneNumber
				+"\n전공 : "+major+"\n학년 : "+grade;
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
		PhoneSchoolInfo phoneSchoolInfo = (PhoneSchoolInfo)obj;
		if(phoneSchoolInfo.name.equals(this.name)) {
			return true;
		}else return false;
	}
}
