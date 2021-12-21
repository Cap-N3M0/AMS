package com.project.ams.service;


import com.project.ams.model.User;


public interface UserService{

	User checkUser(User user);

	boolean registerUser(User user);
	
	void createUser(User user);

	User getUser(Long id);

	User updateUser(User user);

	User findByEmail(String username);	

}
