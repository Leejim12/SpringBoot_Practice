package com.mysite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.domain.MemberDAO;
import com.mysite.domain.MemberDaoH2;
import com.mysite.domain.MemberVO;

@SpringBootTest
class Mission2ApplicationTests {

	@Test
	void Test01() {
		System.out.println("Test01");
	}
	@Test
	void Test02() {
		System.out.println("Test02");
	}
	@Test
	void Test03() {
		System.out.println("Test03");
	}
	@Test
	void Test04() {
		System.out.println("Test04");
	}
	
	@Autowired
	MemberDAO dao;
	
	
	@Test
	void dbtest() {
		MemberDAO dao = new MemberDaoH2();
		MemberVO m = dao.getMemberVO(Integer.toString(1));
		System.out.println(m);
	}
	

}
