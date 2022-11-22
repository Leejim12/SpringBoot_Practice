package com.mysite.domain;

import java.util.List;

public interface MemberDAO {
	// 추상메소드
	List<MemberVO> getMemberVO();
	MemberVO getMemberVO(String uid, String upass);
	int insertWrite(MemberVO vo);
	int updateMember(MemberVO vo);
	int DeleteMember(MemberVO vo);
}
