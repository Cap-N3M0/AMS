package com.project.ams.service;


import java.util.Base64.Encoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.ams.model.User;
import com.project.ams.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@SuppressWarnings("finally")
	public User checkUser(User user) {
		Optional<User> optional = null;
		User ret_user = null;
		User tempUser = null;
		
		try {
			if(user.getEmail() != null) {
				optional = userRepository.findByEmail(user.getEmail());
				
				if(optional.isPresent()) {
					tempUser = optional.get();
					ret_user = tempUser;

					if(user.getPassword()!=null && user.getPassword() != "") {
						System.out.println("Password: Present");

						if(user.getPassword().equalsIgnoreCase(tempUser.getPassword())) {
							ret_user = optional.get();
						}
						else {
							ret_user.setPassword(null);
						}
					}
				}
			}
		}
		catch (Exception e){
			System.out.println("user doesn't exists");
			System.out.println(ret_user);
		}
		finally {
			return ret_user;
		}
	}

	@Override
	public boolean registerUser(User user) {
		userRepository.save(user);
		return false;
	}

	@Override
	public void createUser(User user) {
		
		try {
			System.out.println("user in impl" + user);
			user.setPassword(encode(user.getPassword()));
			userRepository.save(user);
		}
		catch(Exception e) {
			System.out.println("Error Occured:" + e);
		}
	}

	
	public String encode(String password) {	
		
		return new BCryptPasswordEncoder().encode(password);
	}

	@Override
	public User getUser(Long id) {
		User user = null;
		
		user = userRepository.getOne(id);
		return user;
		
	}

	@Override
	public User updateUser(User user) {
		if(user.getPassword() == null || user.getPassword().equalsIgnoreCase("")) {
			user.setPassword(userRepository.getOne(user.getU_id()).getPassword());
		}
		
		User updatedUser = null; 
				
		updatedUser = userRepository.save(user);
		
		return updatedUser;
	}

	@Override
	public User findByEmail(String username) {
		return userRepository.findByEmail(username).get();
		
	}

}
