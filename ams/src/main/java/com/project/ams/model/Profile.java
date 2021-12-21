package com.project.ams.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Profiles")
public class Profile {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long profile_id;
	
	@Column(name = "profile_code")
	private String profile_code;
	
	@Column(name = "profile")
	private String profile;
	
	public Profile() {
	}

	public Profile(long profile_id, String profile_code, String profile) {
		this.profile_id = profile_id;
		this.profile_code = profile_code;
		this.profile = profile;
	}

	public long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}

	public String getProfile_code() {
		return profile_code;
	}

	public void setProfile_code(String profile_code) {
		this.profile_code = profile_code;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Profile [profile_id=" + profile_id + ", profile_code=" + profile_code + ", profile=" + profile + "]";
	}
}
