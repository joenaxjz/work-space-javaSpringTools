package com.demo.interceptors;



import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class Log3Interceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getAttribute("id") != null) {
			System.out.println("id - log 3:" + request.getAttribute("id").toString());
		}
		
		if(request.getAttribute("username") != null) {
			System.out.println("username - log 3:" + request.getAttribute("username").toString());
		}
		
		String url = request.getRequestURL().toString();		
		System.out.println("URL: " + url);
		String uri = request.getRequestURI().toString();		
		System.out.println("URI: " + uri);
		return true;
	
	}
}
