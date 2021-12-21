package com.project.ams.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.ams.model.Post;
import com.project.ams.model.User;
import com.project.ams.repository.CommentRepository;
import com.project.ams.repository.PostRepository;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Page<Post> findAll(Pageable paging) {
		return postRepository.findAllByOrderByCreatedDateDesc(paging);
	}

	@Override
	public void addPost(Post post,User user) {
		Date date = new Date();
		post.setUser(user);
		post.setCreatedBy(user.getFullName());
		post.setCreatedDate(date);
		postRepository.save(post);
		
	}

	@Override
	public Post getPost(long post_id,int page, int size) {
		Post post = null;
		post = postRepository.getOne(post_id);
		
		return post;
	}

	@Override
	public Post getPost(long postId) {
		return postRepository.getOne(postId);
	}
	
	
}
