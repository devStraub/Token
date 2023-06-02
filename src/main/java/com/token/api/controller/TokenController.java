package com.token.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.token.api.service.TokenService;

@RestController
@RequestMapping(value = "/token")
public class TokenController {
	
	@Autowired
	private TokenService tokenService;
	
	@GetMapping("/generate")
	public ResponseEntity<String> generateToken(){
		return ResponseEntity.ok().body(tokenService.generateToken());
	}
	
	@PostMapping("/validate")
	public ResponseEntity<Boolean> validateToken(@RequestBody String token) {
		return ResponseEntity.ok().body(tokenService.validateToken(token));		
	}
}
