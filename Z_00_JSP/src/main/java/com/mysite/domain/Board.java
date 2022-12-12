package com.mysite.domain;

import java.util.Date;

public class Board {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate;
	private int cnt;
	public Board() {
		// TODO Auto-generated constructor stub
	}
	public Board(int seq, String title, String writer, String content, Date createDate, int cnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = createDate;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
}
