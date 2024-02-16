package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.MenusTypesDAO;
import com.appxbuild.matrimony.entity.MenusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenusTypesServiceImpl implements MenusTypesService {

    private MenusTypesDAO menusTypesDAO;

    @Autowired
    public MenusTypesServiceImpl(MenusTypesDAO theMenusTypesDAO){
        menusTypesDAO = theMenusTypesDAO;
    }


    @Override
    public List<MenusTypes> findAll() {
        return menusTypesDAO.findAll();
    }

    @Override
    public MenusTypes findById(int theId) {
        Optional<MenusTypes> result = menusTypesDAO.findById(theId);

        MenusTypes theMenuType = null;
        if (result.isPresent()){
            theMenuType = result.get();
        }
        else {
            throw new RuntimeException("Did not find menu id - " + theId);
        }
        return theMenuType;
    }

    @Override
    public MenusTypes save(MenusTypes theMenusTypes) {
        return menusTypesDAO.save(theMenusTypes);
    }


    @Override
    public void deleteById(int theId) {
        menusTypesDAO.deleteById(theId);
    }
}
