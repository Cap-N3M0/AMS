package com.project.ams.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.ams.model.Comment;
import com.project.ams.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Page<Comment> findByPostIdOrderByCommentDateDesc(long post_id, Pageable pageable) {

		return commentRepository.findByPostPostIdOrderByCommentDateDesc(post_id, pageable);
	}

	@Override
	public void addComment(Comment comment) {
		
		comment.setCommentBy(comment.getUser().getFullName());
		comment.setCommentDate(new Date());
		
		commentRepository.save(comment);
	}

}
