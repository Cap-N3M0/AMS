package com.project.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.ams.model.User;
import com.project.ams.model.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {

	UserLogin findByUsername(String username);
	
}
