package com.mysite.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration	// 클래스 자체도 Bean에 올라가면서 => 만들어가는 객체들도 다 메모리에 올려버림.
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BoardUserDetailsService boardUserDetailsService;
	
	// 소스를 가지고 있는 클래스들은 Annotation 붙이면 됨. @Component @Controller/RestController @Service @Repository
	// @BCryptPasswordEncodder 이런 애들은 소스가 없어서, 올릴 방법이 없음 => 이런 외부에서 제공되는 클래스들을 객체화해서 쓰고싶으면 @Bean으로 올려준다.
	// Repository 처럼, 끼워서 쓸 수 있음. 
	@Bean	// 즉, 이거 없으면 계속 로그인 하라고 할 거임.
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable(); // 브라우저에 외부 접속 된다고 알려주는거임.
		
		http.authorizeHttpRequests() // 지금부터, 권한 관련된 내용들을 설정을 하겠다.
			.requestMatchers("/member/**").authenticated()	// 로그인이 되었으면 접속 가능
			.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")	// 이 두개중 하나 권한 가지고 있어야함. => 텍스트 자체는 임의로 바꿔도 됨.
			.requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN 기능만 됨.
			.anyRequest().permitAll();
		
		http.formLogin().
			loginPage("/login").
			defaultSuccessUrl("/loginSuccess",true);
		
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		http.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		http.userDetailsService(boardUserDetailsService);
		
		return http.build(); 	/// 이렇게 만들어진 객체가 결국 메모리에 올라감. 
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//			.withUser("manager")
//			.password("{noop}manager123")
//			.roles("MANAGER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("{noop}admin123")
//			.roles("ADMIN","MANAGER");
		String query1 = "select id username, concat('{noop}',password) password, "
				+ "true enabled from member where id=?";
		String query2 = "select id, role from member where id=?";
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(query1)
		.authoritiesByUsernameQuery(query2);
	}
}


