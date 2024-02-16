package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsDAO extends JpaRepository<Notifications, Integer> {

}
