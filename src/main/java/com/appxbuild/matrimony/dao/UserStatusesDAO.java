package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.UserStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusesDAO extends JpaRepository<UserStatuses, Integer> {
}
