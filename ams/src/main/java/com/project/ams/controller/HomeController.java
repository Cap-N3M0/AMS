//package com.project.ams.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import com.project.ams.model.User;
//import com.project.ams.model.UserLogin;
//import com.project.ams.repository.UserLoginRepository;
//import com.project.ams.repository.UserRepository;
//import com.project.ams.service.UserService;
//
//@Controller
//public class HomeController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	UserLoginRepository userLoginRepository;
//	
//	@GetMapping("/home")
//	public String showHome() {
//		return "home";
//	}
//	
//	@PostMapping(value="/checkUser/Signin")
//	public String signin( @AuthenticationPrincipal UserLogin userLogin,
//							//@ModelAttribute(name="user")  User user,
//							//BindingResult bindingResult,
//							Model model, 
//							HttpSession session,
//							RedirectAttributes redirectAttributes) {
//		
//		User user = userService.findByEmail(userLogin.getUsername());
//		
//		System.out.println("User : " + user);
//		model.addAttribute("user", user);
//		return "userHome";
////	User userExists = userService.checkUser(user);
////	System.out.println("userExists: " + userExists);
////		if(userExists == null) {
////			redirectAttributes.addFlashAttribute("message", "User doesn't Exists. Please Register first.");
////			return "redirect:/home";
////		}
////		else if(userExists != null && userExists.getPassword()==null){
////			redirectAttributes.addFlashAttribute("message", "Password sahi se daal bhai");
////			return "redirect:/home";
////		}
////		else {
////			session.setAttribute("user", userExists);
////			return "redirect:/userHome";
////		}
//	}
//	
//	@PostMapping(value="/checkUser/Register")
//	public String register(@ModelAttribute(name="user")  User user, RedirectAttributes redirectAttributes,Model model) {
//		System.out.println("home-checkUser-register" + user);
//		User userExists = userService.checkUser(user);
//		
//		System.out.println("UserExists" + userExists);
//		if(userExists != null) {
//			redirectAttributes.addFlashAttribute("message", "User already exists. Sign in Pleaseeee.....");
//			return "redirect:/home";
//		}
//		else {
//			redirectAttributes.addFlashAttribute("user", user);
//			return "redirect:/register";	
//		}
//
//	}
//	
//
//}
