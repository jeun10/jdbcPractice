package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ssamz.biz.common.JDBCUtil;

public class SelectUserTest3 {
	public static void main(String[] args) {
		// 1.UserDAO ��ü�� �����Ѵ�.
		UserDAO dao = new UserDAO();
		// 2. ����� ��ȸ�Ѵ�.
		//dao.getUserList();
		//dao.getUserList2();
		
		List<UserVo> userList = dao.getUserList();
		//Case-1
		System.out.println("��ü ȸ�� �� :"+userList.size());
		//Case-2
		System.out.println("[ȸ���� ����]");
		for(UserVo user : userList) {
			System.out.println(user.getName()+"�� ���� : "+user.getRole());
		}
	}
}
