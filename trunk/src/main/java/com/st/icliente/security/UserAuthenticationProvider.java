package com.st.icliente.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserAuthenticationProvider implements AuthenticationProvider {

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		Authentication authenticationResult = null;

		authenticationResult = new UsernamePasswordAuthenticationToken(null,
				null, loadPermissionList());

		return authenticationResult;
	}

	private Collection<? extends GrantedAuthority> loadPermissionList() {
		List<GrantedAuthority> permissionList = new ArrayList<>();
		permissionList.add(new SimpleGrantedAuthority("ROLE_USER"));
		return permissionList;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}
