package ver09;

import java.sql.SQLException;


public class SelectSQLall extends ConnectDB {

	//생성자메소드
	public SelectSQLall() {}

	@Override
	public void execute() {
		try {

			stmt = con.createStatement();
			System.out.println("주소록전체를 출력합니다.");
			String query = "SELECT pb_name, pb_phoneNumber, pb_birthday FROM phonebook_tb";

			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String pb_name = rs.getString(1);
				String pb_phoneNumber = rs.getString(2);
				String pb_birthday = rs.getString(3);

				System.out.printf("이름 : %s\n전화번호 : %s\n생일 : %s\n",
						pb_name, pb_phoneNumber, pb_birthday);
				System.out.println();
			}
			System.out.println("주소록 출력이 완료되었습니다.");
		}
		catch (SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close(); //DB자원반납
		}
	}
}
