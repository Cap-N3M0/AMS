package com.project.ams.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.ams.model.Post;
import com.project.ams.model.User;

public interface PostService {

	Page<Post> findAll(Pageable paging);

	void addPost(Post post, User user);

	Post getPost(long post_id, int page, int size);

	Post getPost(long postId);
	

}
