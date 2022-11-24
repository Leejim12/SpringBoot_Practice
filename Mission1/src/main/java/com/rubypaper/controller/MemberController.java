package com.rubypaper.controller;
// 미션1
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.MemberVO;



@RestController
public class MemberController {
	private List<MemberVO> memberList;
	
	public MemberController() {
		memberList = new ArrayList<MemberVO>();
		for (int i = 1; i <= 20; i++) {
			MemberVO member = new MemberVO();
			member.setId(i);
			member.setName("이름" + i);
			member.setPass("pass" + i);
			member.setRegidate(new Date());
			memberList.add(member);
		}
	}
	
	@GetMapping("/Member")
	public List<MemberVO> getMembers(){
		return memberList;
	}
	
	//id 찾기 -> get 
	@GetMapping("/Member/{id}")
	public MemberVO getMember(@PathVariable Integer id){
		for(MemberVO m : memberList) {
			if(m.getId()==id)return m;
		}
		return null;
	}
	
	
	@PostMapping("/Member")
	public MemberVO addMember(MemberVO memberVO){
		memberVO.setRegidate(new Date());
		memberVO.setId(memberList.size()+1);
		memberList.add(memberVO);
		return memberVO;
	}
	
	@PutMapping("/Member")
	public MemberVO updateMembers(MemberVO memberVO){
		for(int i = 1;i<=memberList.size()-1;i++) {
			if(memberList.get(i).getId() == memberVO.getId()) {
				memberList.set(i, memberVO);return memberVO;
			}
		}
		memberList.add(memberVO);
		return memberVO;
	}
	
	@DeleteMapping("/Member/{id}")
	public MemberVO removeMember(@PathVariable Integer id){
		for(MemberVO m : memberList) {
			if(m.getId()==id) {
				memberList.remove(m);
				return m;
			}
		}
		return null;
	}
}
