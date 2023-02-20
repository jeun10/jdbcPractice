package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssamz.biz.common.JDBCUtil;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String USER_LIST = "select * from users";
	private String USER_INSERT = "insert into users values(?, ?, ?, ?)";
	private String USER_UPDATE = "update users set name=?, role=? where id=?";
	private String USER_DELETE = "delete users where id=?";
	private String USER_GET ="select * from users where id=?";

	public UserVo getUser(UserVo vo) {
		UserVo user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new UserVo();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, conn, stmt);
		}
		return user;
	}

	

	/*
	 * public void getUserList() { try { conn = JDBCUtil.getConnection(); stmt =
	 * conn.prepareStatement(USER_LIST); rs = stmt.executeQuery();
	 * System.out.println("[USER ���]"); while (rs.next()) {
	 * System.out.print(rs.getString("ID") + " : ");
	 * System.out.print(rs.getString("PASSWORD") + ": ");
	 * System.out.print(rs.getString("NAME") + ": ");
	 * System.out.println(rs.getString("ROLE")); } } catch (SQLException e) {
	 * e.printStackTrace(); } finally { JDBCUtil.close(rs, conn, stmt); } }
	 */
	public List<UserVo> getUserList() {
		List<UserVo> userList = new ArrayList<UserVo>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserVo user = new UserVo();

				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, conn, stmt);
		}
		return userList;
	}

	public void getUserList2() {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			System.out.println("[USER ���]");
			while (rs.next()) {
				System.out.println(rs.getString("NAME") + "�� ����: " + rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, conn, stmt);
		}
	}

	public void getUserCount() {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			int userCount = 0;
			while (rs.next()) {
				userCount++;
			}
			System.out.println("ȸ�� ��: " + userCount);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, conn, stmt);
		}
	}

	// String id, String password, String name, String role
	public void InsertUser(UserVo vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	// String name, String role, String id
	public void UpdateUser(UserVo vo) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getRole());
			stmt.setString(3, vo.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public void DeleteUser(String id) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

}
