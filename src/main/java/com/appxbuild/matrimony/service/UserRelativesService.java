package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.UserRelatives;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRelativesService {

    List<UserRelatives> findAll();
    UserRelatives findById(int theId);
    UserRelatives save(UserRelatives theUserRelatives);
    void deleteById(int theId);
}
