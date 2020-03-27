package ver07;

public class PhoneCompanyInfo extends PhoneInfo{
	String company;
	public PhoneCompanyInfo(String name, String phoneNumber
			, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사 : "+company);
	}
	
	@Override
	public String toString() {
		return "이름 : "+name+"\n전화번호 : "+phoneNumber
				+"\n회사 : "+company;
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
		PhoneCompanyInfo phoneCompanyInfo = (PhoneCompanyInfo)obj;
		if(phoneCompanyInfo.name.equals(this.name)) {
			return true;
		}else return false;
	}
}
