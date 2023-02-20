package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class InsertUserTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = JDBCUtil.getConnection();
			
			//3�ܰ� Statment ����
			String sql = "insert into users values(?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			if(stmt != null) {
			System.out.println("Statement ��ü:"+ stmt.toString());
			}
			
			stmt.setString(1, "ssamz3");
			stmt.setString(2, "ssamz123");
			stmt.setString(3, "����");
			stmt.setString(4, "ADMIN");
			// SQL ����
			int count=stmt.executeUpdate();
			System.out.println(count+"�� ������ ó�� ���� !");

			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.close(conn, stmt);
		}
		

	}//end main
}//end class
