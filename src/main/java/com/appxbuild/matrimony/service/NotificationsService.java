package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Notifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationsService {

    List<Notifications> findAll();
    Notifications findById(int theId);
    Notifications save(Notifications theNotifications);
    void deleteById(int theId);
}
