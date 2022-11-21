package com.mysite.domain;

import java.util.Date;
import java.util.HashMap;

public class MemberVO {
	private int id;
	private String pass;
	private String name;
	private Date regidate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	
	
//	private HashMap<Member,String[]> memberMap;
//	
//	
//	public HashMap<Member, String[]> getMemberMap() {
//		return memberMap;
//	}
//
//	public void setMemberMap(HashMap<Member, String[]> memberMap) {
//		this.memberMap = memberMap;
//		
//	}
}
