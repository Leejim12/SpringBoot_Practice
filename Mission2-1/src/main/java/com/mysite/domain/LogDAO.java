package com.mysite.domain;

import java.util.List;

public interface LogDAO {
	List<LogVO> getLogVO();
	LogVO getLogVO(String idx);
	int InsertLog(LogVO vo);
	int UpdateLog(LogVO vo);
	int DeleteLog(LogVO vo);
}
