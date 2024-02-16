package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.SubscriptionStatuses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionStatusesService {

    List<SubscriptionStatuses> findAll();
    SubscriptionStatuses findById(int theId);
    SubscriptionStatuses save(SubscriptionStatuses theSubscriptionStatuses);
    void deleteById(int theId);

}
