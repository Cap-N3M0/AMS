package com.project.ams.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ams.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	Page<Comment> findByPostPostIdOrderByCommentDateDesc(long post_id, Pageable pageable);

}
