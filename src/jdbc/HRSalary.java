package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HRSalary {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		try {
			// 1. JDBC 드라이버 로딩(JDBC 클래스 로딩)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Get Connection
			// 같은 프로젝트내가 아니기 때문에 Driver가 찾아지지 않는다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");

			System.out.println("Connection Success ");

			// 3. Create Statement

			int max, min;
			System.out.print("최소값을 입력하세요");
			min = sc.nextInt();
			
			System.out.print("최대값을 입력하세요");
			max = sc.nextInt();
			
			// 4. SQL문 실행
			String sql = "select first_name, last_name , salary from employees "
					+"where salary >= ? and salary <=?"
					+ "order by salary";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);

			rs = pstmt.executeQuery();
			
			// 5. 결과 가져오기(사용하기)
			while (rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				int salary = rs.getInt(3);

				System.out.println(firstName + " " + lastName + " " + salary);

			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail : " + e);
		} catch (SQLException e) {
			System.out.println("Connect Fail : " + e);
		} finally {
			// 3. 자원정리
			try {
				if(pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
				sc.close();
			} catch (SQLException e) {
				System.out.println("SQL Exception : " + e);
			}
		}

	}

}
