package com.springmvc.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDAO;
import com.springmvc.model.CustomUserDetails;
import com.springmvc.model.User;
import com.springmvc.model.User_Role;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return loadUser(userName);
	}

	private UserDetails loadUser(String userName) {
		User user = userDAO.findByUserName(userName); 
		if (user == null) {
			return null;
		}
		Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
		Set<User_Role> roles = user.getUserRoles();
		for (User_Role account_Role : roles) {
			grantedAuthoritySet.add(new SimpleGrantedAuthority(account_Role.getRole().getName()));
		}
		return new CustomUserDetails(grantedAuthoritySet, user.getEmail(), user.getFullName(), user.getPassword(),
				user.getUserName(), user.getGender(), user.getAddress(), user.getTelephone(), user.getEnabled(), true,
				true, true);
	}
}
