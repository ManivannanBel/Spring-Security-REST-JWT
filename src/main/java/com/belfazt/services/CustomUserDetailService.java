package com.belfazt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.belfazt.dao.UserRepository;
import com.belfazt.model.User;
import com.belfazt.security.UserPrincipal;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			System.err.println("User not found");
		}
		
		UserPrincipal userPrincipal = new UserPrincipal(user);
		
		return userPrincipal;
		
	}

	
	
}
