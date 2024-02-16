package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.SubscriptionsDAO;
import com.appxbuild.matrimony.entity.Subscriptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionsServiceImpl implements SubscriptionsService{

    private SubscriptionsDAO subscriptionsDAO;

    @Autowired
    public SubscriptionsServiceImpl(SubscriptionsDAO theSubscriptionsDAO){
        subscriptionsDAO = theSubscriptionsDAO;
    }

    @Override
    public List<Subscriptions> findAll() {
        return subscriptionsDAO.findAll();
    }

    @Override
    public Subscriptions findById(int theId) {
        Optional<Subscriptions> result = subscriptionsDAO.findById(theId);
        Subscriptions theSubscription = null;
        if(result.isPresent()){
            theSubscription = result.get();
        }
        else {
            throw new RuntimeException("Subscription id is not found " + theId);
        }
        return theSubscription;
    }

    @Override
    public Subscriptions save(Subscriptions theSubscriptions) {
        return subscriptionsDAO.save(theSubscriptions);
    }

    @Override
    public void deleteById(int theId) {
        subscriptionsDAO.deleteById(theId);
    }
}
