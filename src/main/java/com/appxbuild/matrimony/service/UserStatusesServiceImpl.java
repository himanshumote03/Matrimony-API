package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.UserStatusesDAO;
import com.appxbuild.matrimony.entity.UserStatuses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStatusesServiceImpl implements UserStatusesService {

    private UserStatusesDAO userStatusesDAO;

    public UserStatusesServiceImpl(UserStatusesDAO userStatusesDAO) {
        this.userStatusesDAO = userStatusesDAO;
    }

    @Override
    public List<UserStatuses> findAll() {
        return userStatusesDAO.findAll();
    }

    @Override
    public UserStatuses findById(int theId) {
        Optional<UserStatuses> result = userStatusesDAO.findById(theId);

        UserStatuses theUserStatuses = null;
        if (result.isPresent()){
            theUserStatuses = result.get();
        }
        else {
            throw new RuntimeException("Did not find user status id - " + theId);
        }
        return theUserStatuses;
    }

    @Override
    public UserStatuses save(UserStatuses theUserStatuses) {
        return userStatusesDAO.save(theUserStatuses);
    }


    @Override
    public void deleteById(int theId) {
        userStatusesDAO.deleteById(theId);
    }
}
