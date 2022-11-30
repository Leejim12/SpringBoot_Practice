package com.mysite.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.domain.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO,Long>{
	List<MemberVO> fondByTitle(String searchKeyword);
}
