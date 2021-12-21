package com.project.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.ams.model.User;
import com.project.ams.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String showRegisterHome(@ModelAttribute("user") User user,Model model) {
		model.addAttribute("user", user);
		return "registerHome";
	}
	
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute("user") User user,Model model) {
		
		System.out.println("user  is :" + user);
		userService.createUser(user);
		
		return "redirect:/home";
	}

}
