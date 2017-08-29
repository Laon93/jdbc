package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 로딩(JDBC 클래스 로딩)

			// Class.forName을 사용하여 클래스를 강제로 생성하는것.
			// 왜 A a = new A() 이런식으로 안써?
			// 각 DB마다 부르는 형식이 다르게 라이브러리가 제공될 수 있어서 오라클이 형식을 정해준 것
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("com.bigdata2017.jdbc.MyDriver");

			// 같은 프로젝트내가 아니기 때문에 Driver가 찾아지지 않는다.
			// 그리고 클래스 로딩시 필수적으로 거치는 단계가 있음 --> 드라이버 초기화 시키는 것
			// 그걸 위해 A a = new A() 이렇게 안하는거!!

			// 2. Get Connection
			// 같은 프로젝트내가 아니기 때문에 Driver가 찾아지지 않는다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");

			System.out.println("Connection Success ");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail : " + e);
		} catch (SQLException e) {
			System.out.println("Connect Fail : " + e);
		} finally {
			// 3. 자원정리
			try {
				
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
