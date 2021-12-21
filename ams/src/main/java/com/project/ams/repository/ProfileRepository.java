package com.project.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ams.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
