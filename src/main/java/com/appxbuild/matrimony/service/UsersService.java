package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Users;

import java.util.List;

public interface UsersService {
    // Users
    List<Users> findAll();

    Users findById(int theId);

    Users save(Users users);

    void delete(int theId);

}
