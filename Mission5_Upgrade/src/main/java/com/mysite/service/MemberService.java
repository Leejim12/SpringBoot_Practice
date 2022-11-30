package com.mysite.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.domain.MemberVO;
import com.mysite.persistence.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
	
	public MemberService() {
	}

	public List<MemberVO> getMembers() {
		List<MemberVO> temp = memberRepo.findAll();
		System.out.println("=== 모든 멤버 조회 ===");
		return temp;
	}
	
	
	public MemberVO getMember(int id) {
		MemberVO m = memberRepo.findById(Long.valueOf(id)).get();
		System.out.println("조회 완료 :: ID :" + id);
		return m;
	}
	
	public MemberVO addMember(MemberVO member) {
		memberRepo.save(new MemberVO(
				member.getId(),
				member.getPass(),
				member.getName(),
				new Date()
				));
		System.out.println("삽입 완료 :: ID :" + member.getId());
		return member;
	}
	
	public MemberVO deleteMember(int id) {
		MemberVO temp = getMember(id);
		memberRepo.deleteById(Long.valueOf(id));
		System.out.println("삭제 완료 :: ID :" + id);
		return temp;
	}
	
}
