package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.UserProfileStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileStatusesDAO extends JpaRepository<UserProfileStatuses, Integer> {

}
