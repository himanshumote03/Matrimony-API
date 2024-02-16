package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Menus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenusService {

    List<Menus> findAll();
    Menus findById(int theId);
    Menus save(Menus theMenus);
    void deleteById(int theId);

}
