package com.mysite.dao.log;
import org.springframework.stereotype.Repository;

@Repository("LogH2")
public class LogDaoH2 implements LogDao{
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addLog(String method, String sqlString, boolean success) {
		// TODO Auto-generated method stub
		
	}

}
