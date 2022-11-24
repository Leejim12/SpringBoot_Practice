package com.mysite.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.domain.LogVO;
import com.mysite.domain.MemberVO;
import com.mysite.service.MemberService;


@RestController
public class MemberControllerH2 {
	
	private MemberService memberService;

	private static final Logger Log = LoggerFactory.getLogger(MemberControllerH2.class);
	public MemberControllerH2(MemberService memberService) {
		
		System.out.println("MemberController() 생성자 호출");
		Log.info("MemberController() 생성자 호출");
		this.memberService = memberService;
	}
	
	@GetMapping("/Member")
	public List<MemberVO> getMembers(){
		return memberService.getMembers();
	}
	@GetMapping("/Log")
	public List<LogVO> getLogVO(){
		return memberService.getLogs();
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
