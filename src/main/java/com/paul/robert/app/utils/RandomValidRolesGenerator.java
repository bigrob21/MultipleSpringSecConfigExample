package com.paul.robert.app.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public interface RandomValidRolesGenerator {
	
	public static final List<? extends GrantedAuthority> sysRoles = 
				Arrays.asList(new SimpleGrantedAuthority("LVL1"),
							  new SimpleGrantedAuthority("LVL2"),
			                  new SimpleGrantedAuthority("LVL3"));
	
	
	public static List<? extends GrantedAuthority> generateRoleRoleSet(){
		int loopCount = generateRandomNumber();
		List<GrantedAuthority> retVal = new ArrayList<>();
		for(int i = 0; i < loopCount; i++) {
			int index = generateRandomNumber();
			GrantedAuthority ga = sysRoles.get(index);
			retVal.add(ga);
		}
		return retVal;
	}
	
	public static int generateRandomNumber() {
		final Random random = new SecureRandom();
		final int max = sysRoles.size();
		final int min = 1;
		return random.nextInt((max-min)+min);
	}

}