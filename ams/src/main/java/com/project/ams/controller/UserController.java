package com.project.ams.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ams.model.Post;
import com.project.ams.model.Profile;
import com.project.ams.model.User;
import com.project.ams.service.PostService;
import com.project.ams.service.ProfileService;
import com.project.ams.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping("/userHome")
	public String showUserHome(	HttpSession session,
								Model model,
								RedirectAttributes redirectAttributes,
								Principal principle,
								@RequestParam(defaultValue = "0")int page,
								@RequestParam(defaultValue = "10") int size) {
		
		if(principle != null)
			session.setAttribute("user", userService.findByEmail(principle.getName()));
		else {
			return "redirect:/home?error=true";
		}

		List<Post> postList = new ArrayList<>();
		Pageable paging = PageRequest.of(page, size);
		
		Page<Post> pagePost;
		
		pagePost = postService.findAll(paging);
		postList = pagePost.getContent();
		
		System.out.println("default values: " + page +" "+size);
		System.out.println("Yaya!!!: " + postList);
		System.out.println("Yaya!!!: " + principle.getName());

		
		User user = (User) session.getAttribute("user");
		System.out.println("User Controller: session-user" + user);
		model.addAttribute("user", user);
		model.addAttribute("postList", postList);
		return "userHome";
	}
	
	@GetMapping("/userHome/profile")
	public String getProfile(HttpSession session, User user, Model model) {
		
		List<Profile> listProfiles = null;
		listProfiles = profileService.getAllServices();
		
		System.out.println(listProfiles);
		
		user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("listProfiles", listProfiles);

		return "userProfile";
	}
	
	@PostMapping("userHome/userProfile/updateUser")
	public String updateUser(@ModelAttribute("user") User user,Model model) {
		User updatedUser = null;
		updatedUser = userService.updateUser(user);
		
		model.addAttribute("user",updatedUser);
		return "redirect:/userHome/profile?id="+user.getU_id();
	}

}
