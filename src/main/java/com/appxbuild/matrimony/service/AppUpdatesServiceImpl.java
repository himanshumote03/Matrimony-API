package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.AppUpdatesDAO;
import com.appxbuild.matrimony.entity.AppUpdates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUpdatesServiceImpl implements AppUpdateService{

    private AppUpdatesDAO appUpdatesDAO;

    @Autowired
    public AppUpdatesServiceImpl(AppUpdatesDAO theAppUpdatesDAO){
        appUpdatesDAO = theAppUpdatesDAO;
    }

    @Override
    public List<AppUpdates> findALl() {
        return appUpdatesDAO.findAll();
    }

    @Override
    public AppUpdates findByAll(int theId) {
        Optional<AppUpdates> result = appUpdatesDAO.findById(theId);
        AppUpdates theAppUpdates = null;
        if(result.isPresent()){
            theAppUpdates = result.get();
        }
        else {
            throw new RuntimeException("App Update id is not found " + theId);
        }
        return theAppUpdates;
    }

    @Override
    public AppUpdates save(AppUpdates theAppUpdates) {
        return appUpdatesDAO.save(theAppUpdates);
    }

    @Override
    public void deleteById(int theId) {
        appUpdatesDAO.deleteById(theId);
    }
}
