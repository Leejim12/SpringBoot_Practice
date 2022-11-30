package com.mysite.dao.member;

import java.util.Map;

import com.mysite.domain.MemberVO;

public interface MemberInterface {
	Map<String,Object> getMembers(); 					// 1. 전체조회
	Map<String,Object> getMember(Integer id); 			// 2. 특정값 조회
	Map<String,Object> addMember(MemberVO member); 		// 3. 삽입
	Map<String,Object> updateMember(MemberVO member); 	// 4. 업뎃
	Map<String,Object> deleteMember(Integer id); 		// 5. 제거
}
