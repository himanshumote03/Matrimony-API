package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Notifications;
import com.appxbuild.matrimony.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationsRestController {

    private NotificationsService notificationsService;

    @Autowired
    public NotificationsRestController(NotificationsService theNotificationsService){
        notificationsService = theNotificationsService;
    }

    // expose "/notifications" and return a list of Notifications
    @GetMapping("/notifications")
    public List<Notifications> findAll(){
        return notificationsService.findAll();
    }

    // add mapping for Get /notifications/{notificationId}
    @GetMapping("/notifications/{notificationId}")
    public Notifications getNotification(@PathVariable int notificationId){
        Notifications theNotifications = notificationsService.findById(notificationId);
        if(theNotifications == null){
            throw new RuntimeException("Notification is not found" + notificationId);
        }
        return theNotifications;
    }

     //add mapping for POST /notifications - add new notifications
    @PostMapping("/notifications")
    public Notifications addNotifications(@RequestBody Notifications theNotifications){
        theNotifications.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theNotifications.setCreated(localDateTime);
        theNotifications.setModified(null);
        Notifications newNotification = notificationsService.save(theNotifications);
        return newNotification;
    }

    // add mapping for PUT /notifications - update existing notifications
    @PutMapping("/notifications")
    public Notifications updateNotifications(@RequestBody Notifications theNotifications){
        LocalDateTime localDateTime = LocalDateTime.now();
        theNotifications.setModified(localDateTime);
        Notifications newNotification = notificationsService.save(theNotifications);
        return newNotification;
    }

    // add mapping for DELETE /notifications/{notifications} - delete notifications
    @DeleteMapping("/notifications/{notificationId}")
    public String deleteNotification(@PathVariable int notificationId){
        Notifications theAgency = notificationsService.findById(notificationId);
        notificationsService.deleteById(notificationId);
        // throw exception if null
        if (theAgency == null){
            throw new RuntimeException("Notification id is not found - " + notificationId);
        }
        return "Deleted Notification id - " + notificationId;
    }
}
