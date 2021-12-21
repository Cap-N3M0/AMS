package com.project.ams.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Date createdDate;

	@Column(name="content")
	private String content;
	
	@ManyToOne(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "u_id")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private List<Comment> commentList;

	public Post() {
		
	}

	public Post(long postId, String title, String createdBy, Date createdDate, String content, User user,
			List<Comment> commentList) {
		this.postId = postId;
		this.title = title;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.content = content;
		this.user = user;
		this.commentList = commentList;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", content=" + content + ", user=" + user + ", commentList=" + commentList + "]";
	}

	
}
