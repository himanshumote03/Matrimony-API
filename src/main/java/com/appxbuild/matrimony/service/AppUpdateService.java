package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.AppUpdates;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppUpdateService {

    List<AppUpdates> findALl();

    AppUpdates findByAll(int theId);

    AppUpdates save(AppUpdates theAppUpdates);

    void deleteById(int theId);


}
