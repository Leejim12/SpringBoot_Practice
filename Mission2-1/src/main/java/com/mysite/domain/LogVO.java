package com.mysite.domain;

public class LogVO {
	String idx;
	String time;
	String LogContent;
	public LogVO() {
		super();
	}
	public String getidx() {
		return idx;
	}
	public void setidx(String idx) {
		this.idx = idx;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLogContent() {
		return LogContent;
	}
	@Override
	public String toString() {
		return "LogVO [idx=" + idx + ", time=" + time + ", LogContent=" + LogContent + "]";
	}

	public void setLogContent(String logContent) {
		LogContent = logContent;
	}
	

}
