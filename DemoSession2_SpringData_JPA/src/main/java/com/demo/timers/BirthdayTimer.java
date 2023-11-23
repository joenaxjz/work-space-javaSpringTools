package com.demo.timers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.entities.Account;
import com.demo.services.AccountService;

@Component
public class BirthdayTimer {

	@Autowired
	private AccountService accountService;
	
	@Async
	@Scheduled(cron = " 0 * * * * * ")
	public void sendMail() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		List<Account> accounts = accountService.findByDob();
		if(accounts != null && accounts.size() > 0) {
			System.out.println("accounts: " + accounts.size());
			for (Account account : accounts) {
				System.out.println("full name: " + account.getFullName());
				System.out.println("email: " + account.getEmail());
				System.out.println("dob: " + simpleDateFormat.format(account.getDob()));
				System.out.println("=============================");
				////////// send mail
				
				
			}
		}
	}
	
}
