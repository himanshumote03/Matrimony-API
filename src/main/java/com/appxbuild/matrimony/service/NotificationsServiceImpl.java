package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.NotificationsDAO;
import com.appxbuild.matrimony.entity.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationsServiceImpl implements NotificationsService{
    private NotificationsDAO notificationsDAO;
    @Autowired
    public NotificationsServiceImpl(NotificationsDAO theNotificationsDAO){
        notificationsDAO = theNotificationsDAO;
    }

    @Override
    public List<Notifications> findAll() {
        return notificationsDAO.findAll();
    }

    @Override
    public Notifications findById(int theId) {
        Optional<Notifications> result = notificationsDAO.findById(theId);
        Notifications theNotification = null;
        if(result.isPresent()){
            theNotification = result.get();
        }
        else {
            throw new RuntimeException("Did not find Notification id - " + theId);
        }
        return theNotification;
    }

    @Override
    public Notifications save(Notifications theNotifications) {
        return notificationsDAO.save(theNotifications);
    }

    @Override
    public void deleteById(int theId) {
        notificationsDAO.deleteById(theId);
    }
}
