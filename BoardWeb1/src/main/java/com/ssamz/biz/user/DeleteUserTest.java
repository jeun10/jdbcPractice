package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class DeleteUserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn=JDBCUtil.getConnection();
				
		// JDBC 3�ܰ�: Statement ����
		String sql = "delete users where id=?";
		stmt = conn.prepareStatement(sql);
			
		// JDBC 4�ܰ�: SQL ����
		// ? �� ����
		stmt.setString(1, "ssamz3");
			
		// SQL ����
		int count=stmt.executeUpdate();
		System.out.println(count+"�� ������ ó�� ���� !");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
		JDBCUtil.close(conn,stmt);
		} 
	}

}
