package com.paul.robert.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.paul.robert.security.userdetails.service.AutoPopulatorUserDetailsService;

@Configuration
@Order(100)
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Profile({"!dev"})
public class PKIAutoPopulatorWebSecurityAdapter extends WebSecurityConfigurerAdapter {

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
		return new AutoPopulatorUserDetailsService();
	}
	
}
