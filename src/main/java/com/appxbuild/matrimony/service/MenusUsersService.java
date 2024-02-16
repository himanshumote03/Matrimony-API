package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.MenusUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenusUsersService {

    List<MenusUsers> findAll();
    MenusUsers findById(int theId);
    MenusUsers save(MenusUsers theMenusUsers);
    void deleteById(int theId);

}
