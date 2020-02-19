package com.tmchecking.tm.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tmchecking.tm.domain.Credential;
import com.tmchecking.tm.repository.UserRepo;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Credential> user = userRepo.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("username not founmd"));
		return user.get();
	}

}
