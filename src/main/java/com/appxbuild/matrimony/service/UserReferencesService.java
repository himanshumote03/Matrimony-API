package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.UserReferences;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserReferencesService {

    List<UserReferences> findAll();
    UserReferences findById(int theId);
    UserReferences save(UserReferences theUserReferences);
    void deleteById(int theId);

}
