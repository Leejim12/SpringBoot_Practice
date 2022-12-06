package com.mysite.persistence;

import org.springframework.data.repository.CrudRepository;

import com.mysite.domain.Member;

public interface MemberRepository extends CrudRepository<Member,String>{

}
