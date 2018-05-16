package com.paul.robert.security.userdetails.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.paul.robert.app.utils.RandomValidRolesGenerator;
import com.paul.robert.security.model.AppUser;

public class AutoPopulatorUserDetailsService implements UserDetailsService {

	private Logger log = LoggerFactory.getLogger(getClass());
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == null || username.trim().isEmpty()) {
			//Allow Spring Security to handle the rest.
			log.warn("No username found!!!");
			return null;
		}
		log.debug("Username == " + username);
		AppUser uzer = AppUser.builder().username(username)
			.password(RandomStringUtils.random(25, true, true))
			.authorities(RandomValidRolesGenerator.generateRoleRoleSet())
			.build();
		return uzer;
	}

}
