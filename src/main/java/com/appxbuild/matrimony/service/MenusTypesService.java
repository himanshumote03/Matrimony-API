package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.MenusTypes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenusTypesService {

    List<MenusTypes> findAll();
    MenusTypes findById(int theId);
    MenusTypes save(MenusTypes theMenusTypes);
    void deleteById(int theId);

}
