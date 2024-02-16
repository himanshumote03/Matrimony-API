package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.UserReferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReferencesDAO extends JpaRepository<UserReferences, Integer> {
}
