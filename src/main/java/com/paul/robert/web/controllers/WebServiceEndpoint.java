package com.paul.robert.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Rob Paul Jr
 *
 */
@RestController
public class WebServiceEndpoint {

	@GetMapping("/verify")
	@PreAuthorize("hasAnyAuthority('LVL1','LVL2','LVL3')")
	public ResponseEntity<String> testVerify(){
		return ResponseEntity.ok("Hello I'm working!!!!");
	}
	
}
