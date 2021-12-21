package com.project.ams.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	
	@Column(name="commentBy")
	private String commentBy; 
	
	@Column(name="comment_content")
	private String commentContent;
	
	@Column(name="commentDate")
	private Date commentDate;
	
	@ManyToOne(cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	@JoinColumn(name = "u_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;
	
	public Comment() {
		
	}

	public Comment(long commentId, String commentBy, String commentContent, Date commentDate, User user, Post post) {
		this.commentId = commentId;
		this.commentBy = commentBy;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.user = user;
		this.post = post;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentBy=" + commentBy + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + ", user=" + user + ", post=" + post + "]";
	}	
	
}
