package com.project.ams.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "userLogin")
public class UserLogin implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "accLocked")
	private boolean accLocked;
	
	@Column(name = "accExpired")
	private boolean accExpired;
	
	@Column(name = "credsExpired")
	private boolean credsExpired;
	
	public UserLogin() {
		
	}

	public UserLogin(long id, String username, String password, boolean enabled, boolean accLocked, boolean accExpired,
			boolean credsExpired) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.accLocked = accLocked;
		this.accExpired = accExpired;
		this.credsExpired = credsExpired;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccLocked() {
		return accLocked;
	}

	public void setAccLocked(boolean accLocked) {
		this.accLocked = accLocked;
	}

	public boolean isAccExpired() {
		return accExpired;
	}

	public void setAccExpired(boolean accExpired) {
		this.accExpired = accExpired;
	}

	public boolean isCredsExpired() {
		return credsExpired;
	}

	public void setCredsExpired(boolean credsExpired) {
		this.credsExpired = credsExpired;
	}

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", accLocked=" + accLocked + ", accExpired=" + accExpired + ", credsExpired=" + credsExpired + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
