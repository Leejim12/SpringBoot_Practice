package com.mysite.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.domain.LogDAO;
import com.mysite.domain.LogDaoH2;
import com.mysite.domain.LogVO;
import com.mysite.domain.MemberDAO;
import com.mysite.domain.MemberDaoH2;
import com.mysite.domain.MemberVO;

@Service
public class MemberService {

	private MemberDAO memberDAO;
	private LogDAO logDAO;
	
	public MemberService() {
		memberDAO  = new MemberDaoH2("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
		logDAO = new LogDaoH2("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
	}
	
	public List<MemberVO> getMembers(){
		LogVO TempLog = new LogVO();
		String log = "Search All data";
		TempLog.setContent(log);
		System.out.println(TempLog.getContent());
		logDAO.InsertLog(TempLog);
		
		return memberDAO.getMemberVO();
	}
	
	public List<LogVO> getLogs(){
		return logDAO.getLogVO();
	}
	
	//id 찾기 -> get 
	public MemberVO getMember(String id){
		LogVO TempLog = new LogVO();
		String log = "Search specific data : " + id ;
		TempLog.setContent(log);
		logDAO.InsertLog(TempLog);
		
		List<MemberVO> memberList = memberDAO.getMemberVO();
		for(MemberVO m : memberList) {
			if(m.getId().equals(id)) {
				return memberDAO.getMemberVO(m.getId());
			}
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO){
		LogVO TempLog = new LogVO();
		String log = "Add data : " + memberVO.getId();
		TempLog.setContent(log);
		logDAO.InsertLog(TempLog);
		
		List<MemberVO> memberList = memberDAO.getMemberVO();
		memberVO.setRegidate(String.valueOf(new Date()));
		memberVO.setId(String.valueOf(memberList.size()+1));
		memberList.add(memberVO);
		memberDAO.insertWrite(memberVO);
		return memberVO;
	}
	
	
	public MemberVO updateMembers(MemberVO memberVO){
		LogVO TempLog = new LogVO();
		String log = "Update data : " + memberVO.getId();
		TempLog.setContent(log);
		logDAO.InsertLog(TempLog);
		
		List<MemberVO> memberList = memberDAO.getMemberVO();
		for(int i = 1;i<=memberList.size()-1;i++) {
			if(memberList.get(i).getId() == memberVO.getId()) {
				memberDAO.updateMember(memberVO);
				memberList.set(i, memberVO);return memberVO;
			}
		}
		memberList.add(memberVO);
		return memberVO;
	}
	
	public MemberVO removeMember(String id){
		LogVO TempLog = new LogVO();
		String log = "Remove data : " + id;
		TempLog.setContent(log);
		logDAO.InsertLog(TempLog);
		
		List<MemberVO> memberList = memberDAO.getMemberVO();
		for(MemberVO m : memberList) {
			if(m.getId().equals(id)) {
				memberList.remove(m);
				memberDAO.DeleteMember(m);
				return m;
			}
		}
		return null;
	}	
}
