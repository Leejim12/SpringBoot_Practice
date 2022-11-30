package com.mysite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter05Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Chapter05Application.class);
		application.setWebApplicationType(WebApplicationType.NONE); // 내장 톰캣 실행하지 않고 실행됨.
		application.run(args);
	}

}
