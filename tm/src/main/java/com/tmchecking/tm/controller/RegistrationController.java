package com.tmchecking.tm.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmchecking.tm.domain.Credential;

@RestController
public class RegistrationController {
	
	@GetMapping("/app")
	public ResponseEntity<Credential> app(){
		return ResponseEntity.ok(new Credential());
	}
	
	

}
