package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.UserStatuses;

import java.util.List;

public interface UserStatusesService {
    List<UserStatuses> findAll();
    UserStatuses findById(int theId);
    UserStatuses save(UserStatuses theUserStatuses);
    void deleteById(int theId);
}
