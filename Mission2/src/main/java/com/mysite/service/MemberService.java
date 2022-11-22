package com.mysite.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysite.domain.MemberDAO;
import com.mysite.domain.MemberVO;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO  = new MemberDAO("org.h2.Driver", "jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
	}
	
	public List<MemberVO> getMembers(){
		return memberDAO.getMemberVO();
	}
	
	//id 찾기 -> get 
	public MemberVO getMember(Integer id){
		List<MemberVO> memberList = memberDAO.getMemberVO();
		for(MemberVO m : memberList) {
			if(m.getId()==id)return memberDAO.getMemberVO(m.getId(), m.getPass());
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO){
		List<MemberVO> memberList = memberDAO.getMemberVO();
		memberVO.setRegidate(String.valueOf(new Date()));
		memberVO.setId(String.valueOf(memberList.size()+1));
		memberList.add(memberVO);
		memberDAO.insertWrite(memberVO);
		return memberVO;
	}
	
	
	public MemberVO updateMembers(MemberVO memberVO){
		List<MemberVO> memberList = memberDAO.getMemberVO();
		for(int i = 1;i<=memberList.size()-1;i++) {
			if(memberList.get(i).getId() == memberVO.getId()) {
				memberList.set(i, memberVO);return memberVO;
			}
		}
		memberList.add(memberVO);
		memberDAO.updateMember(memberVO);
		return memberVO;
	}
	
	public MemberVO removeMember(Integer id){
		List<MemberVO> memberList = memberDAO.getMemberVO();
		for(MemberVO m : memberList) {
			if(String.valueOf(m.getId())==String.valueOf(id)) {
				memberList.remove(m);
				memberDAO.DeleteMember(m);
				return m;
			}
		}
		return null;
	}	
}
