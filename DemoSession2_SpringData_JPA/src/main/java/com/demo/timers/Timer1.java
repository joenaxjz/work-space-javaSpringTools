package com.demo.timers;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Timer1 {

	@Async
//	@Scheduled(fixedRate = 1000)
	public void displayCurrentTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(simpleDateFormat.format(new Date()));
	}
	
	@Async
//	@Scheduled(fixedDelay = 1000 * 3)
	public void display2() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Hello");
	}
	
	@Async
//	@Scheduled(cron = " 0 * * * * * ")
	public void display3() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(simpleDateFormat.format(new Date()));
	}
	
	
	
	
}
