package com.project.ams.controller;

import java.io.Console;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SpringWebConstraintValidatorFactory;

/**
 * Servlet implementation class HomeController
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
}
