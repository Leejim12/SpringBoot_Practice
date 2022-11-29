package com.mysite.dao.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class LogDaoH2 implements LogDao{
	private Connection con = null;
	
	public LogDaoH2() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addLog(String method, String sqlString, boolean success) {
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement("insert into dblog(method,sqlString,success) values (?,?,?)");
			psmt.setString(1, method);
			psmt.setString(2, sqlString);
			psmt.setBoolean(3, success);
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
