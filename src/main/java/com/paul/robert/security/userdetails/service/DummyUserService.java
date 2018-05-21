package com.paul.robert.security.userdetails.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.paul.robert.app.utils.RandomValidRolesGenerator;
import com.paul.robert.security.model.AppUser;

public class DummyUserService implements UserDetailsService {

	private List<? extends GrantedAuthority> fixedAuthorities = RandomValidRolesGenerator.sysRoles;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return AppUser.builder()
			.username(username)
			.password("*******************")
			.authorities(fixedAuthorities)
			.build();
	}
	
}