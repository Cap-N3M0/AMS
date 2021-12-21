package com.project.ams.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long u_id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "FULL_NAME", insertable = false, updatable = false)
	private String fullName = firstName + " " + lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name="LASTUPDATEDATE", insertable = false, updatable = false)
	private String lastUpdateDate;
	
	@Column(name = "profile_code")
	private String profile_code;
	
	@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private List<Post> postList;
	
	@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private List<Comment> commentList;
	
	public User() {
		
	}

	public User(long u_id, String firstName, String lastName, String fullName, String email, String password,
			String lastUpdateDate, String profile_code, List<Post> postList, List<Comment> commentList) {
		this.u_id = u_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.lastUpdateDate = lastUpdateDate;
		this.profile_code = profile_code;
		this.postList = postList;
		this.commentList = commentList;
	}

	public long getU_id() {
		return u_id;
	}

	public void setU_id(long u_id) {
		this.u_id = u_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getProfile_code() {
		return profile_code;
	}

	public void setProfile_code(String profile_code) {
		this.profile_code = profile_code;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName
				+ ", email=" + email + ", password=" + password + ", lastUpdateDate=" + lastUpdateDate
				+ ", profile_code=" + profile_code + ", postList=" + postList + ", commentList=" + commentList + "]";
	}

}
