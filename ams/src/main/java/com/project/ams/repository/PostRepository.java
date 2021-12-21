package com.project.ams.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ams.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	Page<Post> findAllByOrderByCreatedDateDesc(Pageable pageable);
	
}
