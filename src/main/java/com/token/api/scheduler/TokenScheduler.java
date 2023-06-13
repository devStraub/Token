package com.token.api.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.token.api.service.TokenService;

@Component
public class TokenScheduler {
	
	@Autowired
	private TokenService tokenService;
	
	@Scheduled(fixedDelay = 60000)
	public void dropExpiredToken() {
		tokenService.dropToken();
	}
}
