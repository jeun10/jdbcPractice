package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class SelectUserTest1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			// 3�ܰ�: Statement
			String sql = "select * from users";
			stmt = conn.prepareStatement(sql);
			// 4�ܰ�: SQL ����
			rs = stmt.executeQuery();
			// 5�ܰ�: ��ȸ ��� ���
			System.out.println("[USER ���]");	
			rs.next();
			System.out.print(rs.getString("ID") + " : ");
			System.out.print(rs.getString("PASSWORD") + " : ");
			System.out.print(rs.getString("NAME") + " : ");
			System.out.println(rs.getString("ROLE"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			JDBCUtil.close(rs, conn, stmt);
		}
	}
}
