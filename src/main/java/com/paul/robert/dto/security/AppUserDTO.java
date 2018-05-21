package com.paul.robert.dto.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.paul.robert.security.model.AppUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserDTO implements Serializable {

	private static final long serialVersionUID = 6232274679483991503L;
	@Getter @Setter
	private String userName;
	@Getter @Setter
	@Builder.Default 
	private List<String> roles = new ArrayList<>();
	
	public static AppUserDTO convertAppUserToUserDTO(final AppUser uzer) {
		if(uzer == null) {
			return null;
		}
		return AppUserDTO.builder()
				.userName(uzer.getUsername())
				.roles(uzer
						.getAuthorities()
						.stream()
						.map(a -> {return a.getAuthority();}).collect(Collectors.toList()))
						.build();
	}
	
}