package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UsersDAO;
import com.appxbuild.matrimony.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersDAO usersDAO;

    public UsersServiceImpl (UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }


    @Override
    public List<Users> findAll() {
        return usersDAO.findAll();
    }

    @Override
    public Users findById(int theId) {
        Optional<Users> result = usersDAO.findById(theId);

        Users users = null;
        if (result.isPresent()) {
            users = result.get();
        }
        else {
            throw new RuntimeException("Did not find Agency id: " + theId);
        }

        return users;
    }

    @Override
    public Users save(Users users) {
        return usersDAO.save(users);
    }

    @Override
    public void delete(int theId) {
        usersDAO.deleteById(theId);
    }


}
