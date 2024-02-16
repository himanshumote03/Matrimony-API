package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.MenusDAO;
import com.appxbuild.matrimony.entity.Menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenusServiceImpl implements MenusService {

    private MenusDAO menusDAO;

    @Autowired
    public MenusServiceImpl(MenusDAO theMenusDAO){
        menusDAO = theMenusDAO;
    }


    @Override
    public List<Menus> findAll() {
        return menusDAO.findAll();
    }

    @Override
    public Menus findById(int theId) {
        Optional<Menus> result = menusDAO.findById(theId);

        Menus theMenu = null;
        if (result.isPresent()){
            theMenu = result.get();
        }
        else {
            throw new RuntimeException("Did not find menu id - " + theId);
        }
        return theMenu;
    }

    @Override
    public Menus save(Menus theMenus) {
        return menusDAO.save(theMenus);
    }


    @Override
    public void deleteById(int theId) {
        menusDAO.deleteById(theId);
    }
}
