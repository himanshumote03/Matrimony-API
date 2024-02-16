package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.SubscriptionStatuses;
import com.appxbuild.matrimony.service.SubscriptionStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscriptionStatusesRestController {

    private SubscriptionStatusesService subscriptionStatusesService;

    @Autowired
    public SubscriptionStatusesRestController(SubscriptionStatusesService theSubscriptionStatusesService){
        subscriptionStatusesService = theSubscriptionStatusesService;
    }

    // expose "/subscription_statuses" and return a list of subscription statuses
    @GetMapping("/subscription_statuses")
    public List<SubscriptionStatuses> findAll(){
        return subscriptionStatusesService.findAll();
    }

}
