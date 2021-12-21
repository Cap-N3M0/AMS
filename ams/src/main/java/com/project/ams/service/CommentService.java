package com.project.ams.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.project.ams.model.Comment;

public interface CommentService {

	Page<Comment> findByPostIdOrderByCommentDateDesc(long post_id, Pageable pageable);

	void addComment(Comment comment);

}
