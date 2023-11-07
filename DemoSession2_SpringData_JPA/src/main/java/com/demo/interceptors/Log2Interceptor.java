package com.demo.interceptors;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class Log2Interceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getAttribute("id") != null) {
			System.out.println("id - log 2:" + request.getAttribute("id").toString());
		}
		
		if(request.getAttribute("username") != null) {
			System.out.println("username - log 2:" + request.getAttribute("username").toString());
		}
		
		String ip = request.getRemoteAddr();		
		System.out.println("ip: " + ip);
		return true;
	
	}
}
