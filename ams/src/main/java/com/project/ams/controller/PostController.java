package com.project.ams.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.ams.model.Comment;
import com.project.ams.model.Post;
import com.project.ams.model.User;
import com.project.ams.service.CommentService;
import com.project.ams.service.PostService;
import com.project.ams.service.UserService;

@Controller
public class PostController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	CommentService commentService;
	
//	@PostMapping("post/addPost")
//	public void addPost(@RequestParam("id")long u_id,
//							@ModelAttribute("post")Post post, 
//							RedirectAttributes redirectAttributes) {
//		
//		User user = userService.getUser(u_id);
//		postService.addPost(post,user);
//	}
	
	@ResponseBody
	@PostMapping(value = "post/addPost")
	public void addPost(@RequestParam("id")long u_id,
						@RequestBody Post post,
						RedirectAttributes redirectAttributes) {
		System.out.println("value aa rhi hai add Post tk");
		
		User user = userService.getUser(u_id);
		postService.addPost(post,user);
	}
	
	@GetMapping("/post")
	public String showPost(@RequestParam("postId")long post_id, 
							@RequestParam(defaultValue = "0") int page,
							@RequestParam(defaultValue = "10") int size,
							HttpSession session,
							Model model){
		
		Post post = null;
		post = postService.getPost(post_id,page,size);
		
		List<Comment> commentList = null;
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Comment> pageComment;
		
		pageComment = commentService.findByPostIdOrderByCommentDateDesc(post_id, pageable);
		commentList = pageComment.getContent();
		
		System.out.println("post details : " + post +"\n"+commentList);
		
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("post", post);
		model.addAttribute("commentList", commentList);
		return "postHome";
		
	}
	
//	@PostMapping("addComment")
//	public String addComment(@ModelAttribute("comment") Comment comment,
//								@RequestParam("userId") long userId,
//								@RequestParam("postId") long postId,
//								Model model) {
//
//		User user = userService.getUser(userId);
//		Post post = postService.getPost(postId);
//		
//			
//		comment.setUser(user);
//		comment.setPost(post);
//		commentService.addComment(comment);
//		
//		return showPost(postId,userId,0,10,model);
//	}

	@ResponseBody
	@PostMapping("addComment")
	public void addComment(@RequestBody Comment comment,
								@RequestParam("userId") long userId,
								@RequestParam("postId") long postId) {

		User user = userService.getUser(userId);
		Post post = postService.getPost(postId);
		
		System.out.println("Haan bhyu aa rha hai data??");
		comment.setUser(user);
		comment.setPost(post);
		commentService.addComment(comment);
		
	}	
	
}
