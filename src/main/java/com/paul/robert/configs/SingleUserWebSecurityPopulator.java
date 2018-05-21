package com.paul.robert.configs;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.paul.robert.app.utils.RandomValidRolesGenerator;
import com.paul.robert.security.model.AppUser;
import com.paul.robert.security.userdetails.service.DummyUserService;

/**
 * In secure always returns the same user!!
 * @author Rob Paul Jr
 *
 */
@EnableWebSecurity
@Order(200)
@Profile("dev")
public class SingleUserWebSecurityPopulator extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.x509()
			.subjectPrincipalRegex(("(^.*)"))
			.userDetailsService(userDetailsService())
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf()
			.disable();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new DummyUserService();
	}
	
}