package com.mysite.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.MemberRepository;
import com.mysite.domain.Member;

@Service
public class BoardUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepo;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> optional = memberRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username + "사용자를 찾을 수 없습니다.");
		}
		
		Member m = optional.get();
//		return new User(m.getId(),m.getPassword(),AuthorityUtils.createAuthorityList(m.getRole().toString()));
		return User.builder()
				.username(m.getId())
				.password(m.getPassword())
				.roles(m.getRole().toString())
				.build();
	}

}
