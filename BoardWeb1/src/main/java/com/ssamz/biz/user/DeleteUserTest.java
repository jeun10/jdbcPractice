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
				
		// JDBC 3단계: Statement 생성
		String sql = "delete users where id=?";
		stmt = conn.prepareStatement(sql);
			
		// JDBC 4단계: SQL 전송
		// ? 값 설정
		stmt.setString(1, "ssamz3");
			
		// SQL 전송
		int count=stmt.executeUpdate();
		System.out.println(count+"건 데이터 처리 성공 !");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
		JDBCUtil.close(conn,stmt);
		} 
	}

}
