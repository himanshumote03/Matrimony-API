package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.MenusUsersDAO;
import com.appxbuild.matrimony.entity.MenusUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenusUsersServiceImpl implements MenusUsersService {

    private MenusUsersDAO menusUsersDAO;

    @Autowired
    public MenusUsersServiceImpl(MenusUsersDAO theMenusUsersDAO){
        menusUsersDAO = theMenusUsersDAO;
    }


    @Override
    public List<MenusUsers> findAll() {
        return menusUsersDAO.findAll();
    }

    @Override
    public MenusUsers findById(int theId) {
        Optional<MenusUsers> result = menusUsersDAO.findById(theId);

        MenusUsers theMenusUser = null;
        if (result.isPresent()){
            theMenusUser = result.get();
        }
        else {
            throw new RuntimeException("Did not find menu user id - " + theId);
        }
        return theMenusUser;
    }

    @Override
    public MenusUsers save(MenusUsers theMenusUsers) {
        return menusUsersDAO.save(theMenusUsers);
    }


    @Override
    public void deleteById(int theId) {
        menusUsersDAO.deleteById(theId);
    }
}
