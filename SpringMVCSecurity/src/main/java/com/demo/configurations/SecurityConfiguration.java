package com.demo.configurations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.demo.services.AccountService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
					auth.requestMatchers(
							"/home/**",
							"/aboutus/**",
							"/account/login",
							"/account/register",
							"/account/forgetPassword",
							"/account/accessdenied",
							"/account/success"
							).permitAll()
					.requestMatchers("/superadmin/**").hasAnyRole("super_admin") // các role sẽ được vào đường link
					.requestMatchers("/admin/**").hasAnyRole("super_admin", "admin")
					.requestMatchers("/employee/**", "/account/profile").hasAnyRole("super_admin", "admin", "emp");
				})
				.formLogin(formLogin -> {
					formLogin.loginPage("/account/login")
					.loginProcessingUrl("/account/process-login")
					// lấy trong form login
					.usernameParameter("username")
					.passwordParameter("password")
					//.defaultSuccessUrl("/account/success")
					// tuy` chinh duong dan
					.successHandler(new AuthenticationSuccessHandler () {
						@Override
						public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
								Authentication authentication) throws IOException, ServletException {
							Map<String, String> urls = new HashMap<String, String>();
							urls.put("ROLE_super_admin", "/superadmin/invoice");
							urls.put("ROLE_admin", "/admin/category");
							urls.put("ROLE_emp", "/employee/product");
							String url = "";
							for(GrantedAuthority role : authentication.getAuthorities()) {
								System.out.println(role.getAuthority());
								if(urls.containsKey(role.getAuthority())) {
									url = urls.get(role.getAuthority());
									
									break;
								}
							}
							System.out.println("Role: " + url);
							response.sendRedirect(url);
						}
						
					})
					.failureUrl("/account/login?failed");
				})
				.logout(logout -> {
					logout.logoutUrl("/account/logout")
					.logoutSuccessUrl("/account/login");
				})
				.exceptionHandling(ex -> {
					ex.accessDeniedPage("/account/accessdenied"); // phai khai bao trong Controller
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
