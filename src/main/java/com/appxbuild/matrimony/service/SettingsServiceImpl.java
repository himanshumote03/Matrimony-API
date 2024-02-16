package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.SettingsDAO;
import com.appxbuild.matrimony.entity.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingsServiceImpl implements SettingsService{

    private SettingsDAO settingsDAO;

    @Autowired
    public SettingsServiceImpl(SettingsDAO theSettingsDAO){
        settingsDAO = theSettingsDAO;
    }

    @Override
    public List<Settings> findAll() {
        return settingsDAO.findAll();
    }

    @Override
    public Settings findById(int theId) {
        Optional<Settings> result = settingsDAO.findById(theId);
        Settings theSetting = null;
        if(result.isPresent()){
            theSetting = result.get();
        }
        else {
            throw new RuntimeException("Setting id is not found " + theId);
        }
        return theSetting;
    }

    @Override
    public Settings save(Settings theSettings) {
        return settingsDAO.save(theSettings);
    }

    @Override
    public void deleteById(int theId) {
        settingsDAO.deleteById(theId);
    }
}
