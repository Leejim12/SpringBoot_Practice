package com.mysite.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.domain.MemberVO;
import com.mysite.service.MemberService;

@RestController
public class MemberController {
	private MemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	public MemberController(MemberService memberService) {
		log.info("MemberController() 생성자 호출");
		this.memberService = memberService;
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		log.info("MemberController - getMembers()가 호출됨.");
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		log.info(String.format("MemberController - getMember(%d)가 호출됨.", id));
		return memberService.getMember(id);
	}
	
	@GetMapping("/member/body")
	public MemberVO getMemberbyJSON(@RequestBody MemberVO member) {
		log.info(String.format("MemberController - getMemberbyJSON(%s)이 호출됨", member));
		return memberService.getMember(member.getId().intValue());
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		log.info(String.format("MemberController - addMember(%s)가 호출됨.", member));
		return memberService.addMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO deleteMember(@PathVariable Integer id) {
		log.info(String.format("MemberController - deleteMember(%d)가 호출됨", id));
		return memberService.deleteMember(id);
	}
}
