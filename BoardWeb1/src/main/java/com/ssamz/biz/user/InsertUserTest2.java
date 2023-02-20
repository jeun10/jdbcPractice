package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssamz.biz.common.JDBCUtil;

public class InsertUserTest2 {

	public static void main(String[] args) {
		
		UserDAO dao = new UserDAO();
		// 2. 목록을 조회한다.
		UserVo vo= new UserVo();
		vo.setName("쌤즈");
		vo.setRole("USER");

		vo.setId("ssamz4");
		
		vo.setPassword("ssamz123");
		dao.InsertUser(vo);
		dao.getUserList();


		

	}//end main
}//end class
