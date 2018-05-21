package com.paul.robert.app.utils;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.paul.robert.security.model.AppUser;

public final class SecurityUtils {

	private SecurityUtils() {}
	
	public static Optional<AppUser> getPrincipal() {
		SecurityContext secCtx = SecurityContextHolder.getContext();
		return Optional.ofNullable(secCtx)
		.filter(c -> c.getAuthentication() != null)	
		.map(SecurityContext::getAuthentication)
		.map(Authentication::getPrincipal)
		.filter(auth -> auth != null)
		.map(auth -> {return (AppUser)auth;});	
	}
	
	/*public static void main(String[] args) {
		AppUser uzer = AppUser.builder().username("test")
			.password("foo")
			.authorities(Arrays.asList(new SimpleGrantedAuthority("foobar")))
			.build();
		PreAuthenticatedAuthenticationToken authToken = 
				new PreAuthenticatedAuthenticationToken(uzer, uzer.getPassword(), uzer.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authToken);
		
		Optional<AppUser> optUzer = getPrincipal();
		System.out.println("Uzer = " + optUzer.orElseThrow(() -> new IllegalStateException("Total Fail!!")));
	}*/
	
}