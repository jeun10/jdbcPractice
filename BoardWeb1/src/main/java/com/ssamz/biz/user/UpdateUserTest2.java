package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class UpdateUserTest2 {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		System.out.println("������----");
		dao.getUserList();

		UserVo vo = new UserVo();
		vo.setName("����");
		vo.setRole("USER");
		vo.setId("ssamz4");
		dao.UpdateUser(vo);
		System.out.println("������----");
		dao.getUserList();
	}

}
