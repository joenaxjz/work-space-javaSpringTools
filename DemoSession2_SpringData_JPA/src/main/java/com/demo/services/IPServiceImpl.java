package com.demo.services;

import org.springframework.stereotype.Service;

@Service
public class IPServiceImpl implements IPService {
	
	private String [] ipblocks = {
		// dia chi dat trong day
	};
	
	@Override
	public boolean valid(String ip) {
		for ( String ipblock : ipblocks) {
			if(ip.equalsIgnoreCase(ipblock)) {
				return false;
			}
		}
		return true;
	}

}
