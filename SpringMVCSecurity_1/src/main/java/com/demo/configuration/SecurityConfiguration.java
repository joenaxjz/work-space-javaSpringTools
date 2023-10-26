package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.demo.service.AccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
 // khai bao cau hinh o trong nay de chon nguoi su dung hay khong
	@Autowired
	private AccountService accountService;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
				.cors(cor -> cor.disable())
				.csrf(csf -> csf.disable())
				.authorizeHttpRequests(auth -> {
					// chi ra nhung duong dan nao cho user truy xuat
					auth.requestMatchers("/","/home/**","/aboutus/**","/account/login","/account/register").permitAll()
					.requestMatchers("/superadmin/**").hasAnyRole("Super_Admin")
					.requestMatchers("/admin/**").hasAnyRole("Super_Admin","Admin")
					.requestMatchers("/manager/**","/account/welcome").hasAnyRole("Super_Admin","Admin","Manager");
				})
				.formLogin(formLogin ->{
					formLogin.loginPage("/account/login")
						.loginProcessingUrl("/account/process-login")
						.usernameParameter("username")
						.passwordParameter("password")
						.defaultSuccessUrl("/account/welcome")
						.failureUrl("/account/login?error")
					;
				})
				.build();
	}
	
	@Autowired
	public void configGolbal(AuthenticationManagerBuilder builder) throws Exception{
		builder.userDetailsService(accountService);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
