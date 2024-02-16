package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.UserProfiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfilesDAO extends JpaRepository<UserProfiles, Integer> {
}
