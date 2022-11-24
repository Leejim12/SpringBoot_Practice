package com.mysite.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.domain.MemberDaoList;
import com.mysite.domain.MemberVO;

@RestController
public class MemberControllerList {
	private MemberDaoList memberList;
	
	public MemberControllerList() {
		memberList = new MemberDaoList();
	}
	
	@GetMapping("/ML")
	public List<MemberVO> getMembers(){
		return memberList.getMemberVO();
	}
	
	@GetMapping("/ML/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return memberList.getMemberVO(id);
	}
	
	@PostMapping("/ML")
	public List<MemberVO> addMember(MemberVO memberVO){
		memberList.insertWrite(memberVO);
	return memberList.getMemberVO();
	}
	
	@PutMapping("/ML")
	public List<MemberVO> updateMember(MemberVO memberVO){
		memberList.updateMember(memberVO);
		return memberList.getMemberVO();
	}
	
	@DeleteMapping("/ML/{id}")
	public int removeMember(@PathVariable Integer id) {
		MemberVO temp = new MemberVO();
		temp.setId(Integer.toString(id));
		return memberList.DeleteMember(temp);
	}
}
