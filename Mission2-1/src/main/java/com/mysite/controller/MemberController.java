package com.mysite.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.domain.MemberVO;
import com.mysite.service.MemberService;



@RestController
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	@GetMapping("/Member")
	public List<MemberVO> getMembers(){
		return memberService.getMembers();
	}
	
	@GetMapping("/Member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return memberService.getMember(id);	
	}
	
	@PostMapping("/Member")
	public MemberVO addMember(MemberVO m) {
		return memberService.addMember(m);
	}
	
	@PutMapping("/Member")
	public MemberVO updateMember(MemberVO m) {
		return memberService.updateMembers(m);
	}
	
	@DeleteMapping("/Member/{id}")
	public MemberVO removeMember(@PathVariable String id) {
		return memberService.removeMember(id);
	}
	
}
