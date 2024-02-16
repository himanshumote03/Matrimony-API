package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.UserProfileStatuses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProfileStatusesService {

    List<UserProfileStatuses> findAll();
    UserProfileStatuses findById(int theId);
    UserProfileStatuses save(UserProfileStatuses theUserProfileStatuses);
    void deleteById(int theId);

}
