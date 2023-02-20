package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class UpdateUserTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn=JDBCUtil.getConnection();
			
			String sql = "update users set name=?, role=? where id=?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "����");
			stmt.setString(2, "USER");
			stmt.setString(3, "ssamz3");
				
			// SQL ����
			int count=stmt.executeUpdate();
			System.out.println(count+"�� ������ ó�� ���� !");

		}catch(SQLException e) {
			e.printStackTrace();

		}
		finally {
			JDBCUtil.close(conn, stmt);
		}
	}

}
