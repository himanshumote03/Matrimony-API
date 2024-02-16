package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Subscriptions;
import com.appxbuild.matrimony.service.SubscriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscriptionsRestController {

    private SubscriptionsService subscriptionsService;

    @Autowired
    public SubscriptionsRestController(SubscriptionsService theSubscriptionsService){
        subscriptionsService = theSubscriptionsService;
    }

    // expose "/subscriptions" and return a list of subscriptions
    @GetMapping("/subscriptions")
    public List<Subscriptions> findAll(){
        return subscriptionsService.findAll();
    }

    // add mapping for Get "/subscriptions/{subscriptionId}"
    @GetMapping("/subscriptions/{subscriptionId}")
    public Subscriptions getSubscription(@PathVariable int subscriptionId){
        Subscriptions theSubscription = subscriptionsService.findById(subscriptionId);

        if(theSubscription == null){
            throw new RuntimeException("Subscription is not found" + subscriptionId);
        }
        return theSubscription;
    }

    //add mapping for POST "/subscriptions" - add new Subscription
    @PostMapping("/subscriptions")
    public Subscriptions addSubscription(@RequestBody Subscriptions theSubscriptions){
        theSubscriptions.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theSubscriptions.setCreated(localDateTime);
        theSubscriptions.setModified(null);
        Subscriptions newSubscription = subscriptionsService.save(theSubscriptions);
        return newSubscription;
    }

    //add mapping for PUT "/subscriptions" - add new Subscription
    @PutMapping("/subscriptions")
    public Subscriptions updateSubscription(@RequestBody Subscriptions theSubscriptions){
        theSubscriptions.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theSubscriptions.setModified(localDateTime);
        Subscriptions newSubscription = subscriptionsService.save(theSubscriptions);
        return newSubscription;
    }

    // add mapping for DELETE "/subscriptions/{subscriptionId}" to delete Subscription
    @DeleteMapping("/subscriptions/{subscriptionId}")
    public String deleteSubscription(@PathVariable int subscriptionId){
        Subscriptions theSubscription = subscriptionsService.findById(subscriptionId);
        subscriptionsService.deleteById(subscriptionId);
        if(theSubscription == null){
            throw new RuntimeException("Subscription is not found" + subscriptionId);
        }
        return "Deleted Subscription id " + subscriptionId;
    }

}
