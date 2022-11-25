package com.mysite.dao.log;

public interface LogDao {
	void addLog(String method,String sqlString, boolean success);
}
