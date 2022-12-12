package com.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/")
	public String index() {
		System.out.println("index 요청입니다.");
		return "index";
	}
	
	@GetMapping("/member")
	public void forMember() {
		System.out.println("Member 요청입니다.");
	}
	// 어노테이션이랑 뷰 이름 같을땐 void로 해도 됨.
	// 다른걸로 할땐 String 이런걸로 하고 리턴 타입을 지정해주면 됨.
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("Manager 요청입니다");
	}

	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("Admin 요청입니다.");
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
	}
}


