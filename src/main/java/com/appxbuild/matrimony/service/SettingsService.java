package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Settings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SettingsService {

    List<Settings> findAll();
    Settings findById(int theId);
    Settings save(Settings theSettings);
    void deleteById(int theId);

}
