package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.Subscriptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionsService {

    List<Subscriptions> findAll();
    Subscriptions findById(int theId);
    Subscriptions save(Subscriptions theSubscriptions);
    void deleteById(int theId);

}
