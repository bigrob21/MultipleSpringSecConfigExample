package com.paul.robert.web.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paul.robert.app.utils.SecurityUtils;
import com.paul.robert.dto.security.AppUserDTO;
import com.paul.robert.security.model.AppUser;

/**
 * 
 * @author Rob Paul Jr
 *
 */
@RestController
public class WebServiceEndpoint {

	@GetMapping("/")
	@PreAuthorize("hasAnyAuthority({'LVL1','LVL2','LVL3'})")
	public ResponseEntity<AppUserDTO> testVerify(){
		Optional<AppUser> optAppUzer = SecurityUtils.getPrincipal();
		return optAppUzer
			.map(u -> {
				return AppUserDTO.convertAppUserToUserDTO(u);
			})
			.map(u -> {return ResponseEntity.ok(u);})
			//Most likely this will never execute
			.orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
	}
	
}
