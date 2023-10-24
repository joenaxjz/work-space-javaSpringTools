package com.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.demo.services.AccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private AccountService accountService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception  {
		return httpSecurity
				.cors(cor -> cor.disable())
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> {
					// những đường dẫn cho truy xuất
					auth.requestMatchers("/",
							"/home/**",
							"/aboutus/**",
							"/account/login",
							"/account/register",
							"/account/forgetPassword").permitAll()
					.requestMatchers("/superadmin/**").hasAnyRole("1") // các role sẽ được vào đường link
					.requestMatchers("/admin/**").hasAnyRole("1", "2")
					.requestMatchers("/employee/**", "/account/success", "/account/profile").hasAnyRole("1", "2", "3");
				})
				.formLogin(formLogin -> {
					formLogin.loginPage("/account/login")
					.loginProcessingUrl("/account/process-login")
					// lấy trong form login
					.usernameParameter("username")
					.passwordParameter("password")
					.defaultSuccessUrl("/account/success")
					.failureUrl("/account/login?failed");
				})
				.build();
	}
	
	@Autowired
	public void configGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(accountService);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
