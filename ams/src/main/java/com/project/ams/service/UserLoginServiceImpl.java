package com.project.ams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.ams.model.User;
import com.project.ams.model.UserLogin;
import com.project.ams.model.UserLoginDetails;
import com.project.ams.repository.UserLoginRepository;

public class UserLoginServiceImpl implements UserLoginService, UserDetailsService{
	
	@Autowired
	UserLoginRepository userLoginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin userLogin = userLoginRepository.findByUsername(username);
		
		if(userLogin == null) {
			throw new UsernameNotFoundException(username);
		}
		return  new UserLoginDetails(userLogin);
	}
	
}
