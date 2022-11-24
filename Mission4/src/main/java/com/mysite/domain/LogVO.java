package com.mysite.domain;

public class LogVO {
	String idx;
	String time;
	String Content;
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
	public String getContent() {
		return Content;
	}
	@Override
	public String toString() {
		return "LogVO [idx=" + idx + ", time=" + time + ", Content=" + Content + "]";
	}

	public void setContent(String Content) {
		this.Content = Content;
	}
	

}
