package com.bigdata2017.jdbc.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bigdata2017.jdbc.bookshop.vo.BookVo;

public class BookDao {
	
	private Connection getConnection() throws SQLException{
		
		Connection conn = null;
		
		try {
			//1. JDBC 드라이버 로딩(JDBC 클래스 로딩)
			Class.forName( "oracle.jdbc.driver.OracleDriver" );

			//2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection( url, "dev", "dev" );
		
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		}
		
		return conn;
	}
	
	public int delete() {
		int count = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "delete from book";
			count = stmt.executeUpdate( sql );
		}catch (SQLException e) {
			System.out.println( "error :" + e );
		} finally {
			//3.자원 정리
			try {
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return count;
	}
	
	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();
		
		
		return list;
	}
	
	
	
	public int insert( BookVo vo ) {
		int count = 0;
		
		return count;
	}
	
	public int updateState( Long no, String state ) {
		int count = 0;
		
		
		
		return count;
	}
}