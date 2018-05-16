package com.paul.robert.security.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUser implements UserDetails {

	private static final long serialVersionUID = 8657646535406324831L;
	
	private String password;
	private String username;
	@Builder.Default private Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
	@Builder.Default private boolean accountNonExpired = true;
	@Builder.Default private boolean accountNonLocked = true;
	@Builder.Default private boolean credentialsNonExpired =true;
	@Builder.Default private boolean enabled = true;

}