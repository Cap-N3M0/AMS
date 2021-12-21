package com.project.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ams.model.Profile;
import com.project.ams.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Override
	public List<Profile> getAllServices() {
		
		List<Profile> listProfiles = null;
		listProfiles = profileRepository.findAll();
		
		return listProfiles;
	}
	
	
	
}
