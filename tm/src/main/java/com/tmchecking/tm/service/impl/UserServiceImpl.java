package com.tmchecking.tm.service.impl;

import java.util.Optional;

import com.tmchecking.tm.domain.Credential;
import com.tmchecking.tm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Credential> user = userRepo.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("Username not found Exception"));
		return user.get();
	}

}
