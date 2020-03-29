package ver09;

import java.sql.SQLException;
import java.util.Scanner;


public class SelectSQL extends ConnectDB {

	//생성자메소드
	public SelectSQL() {}

	@Override
	public void execute() {
		try {
			Scanner scan = new Scanner(System.in);
			stmt = con.createStatement();
			System.out.print("검색할 이름을 입력하세요 : ");
			String pb_name = scan.nextLine();
			
			String query = "SELECT pb_name, pb_phoneNumber, "
					+ "pb_birthday FROM phonebook_tb where "
					+ "pb_name like '%"+pb_name+"%'";

			rs = stmt.executeQuery(query);
			while(rs.next()) {
				pb_name = rs.getString(1);
				String pb_phoneNumber = rs.getString(2);
				String pb_birthday = rs.getString(3);

				System.out.printf("이름 : %s\n전화번호 : %s\n생일 : %s\n",
						pb_name, pb_phoneNumber, pb_birthday);
				System.out.println();
			}
			System.out.println("검색이 완료되었습니다.");
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
