package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class DeleteUserTest2 {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();

		System.out.println("삭제전----");
		dao.getUserList();
		dao.DeleteUser("ssamz3");
		System.out.println("삭제후----");
		dao.getUserList();
	}
}
