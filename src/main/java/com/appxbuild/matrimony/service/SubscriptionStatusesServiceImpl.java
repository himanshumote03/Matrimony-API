package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.SubscriptionStatusesDAO;
import com.appxbuild.matrimony.entity.SubscriptionStatuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionStatusesServiceImpl implements SubscriptionStatusesService{

    private SubscriptionStatusesDAO subscriptionStatusesDAO;

    @Autowired
    public SubscriptionStatusesServiceImpl(SubscriptionStatusesDAO theSubscriptionStatusesDAO){
        subscriptionStatusesDAO = theSubscriptionStatusesDAO;
    }

    @Override
    public List<SubscriptionStatuses> findAll() {
        return subscriptionStatusesDAO.findAll();
    }

    @Override
    public SubscriptionStatuses findById(int theId) {
        Optional<SubscriptionStatuses> result = subscriptionStatusesDAO.findById(theId);
        SubscriptionStatuses theSubscriptionStatus = null;
        if(result.isPresent()){
            theSubscriptionStatus = result.get();
        }
        else {
            throw new RuntimeException("Subscription Status id is not found " + theId);
        }
        return theSubscriptionStatus;
    }

    @Override
    public SubscriptionStatuses save(SubscriptionStatuses theSubscriptionStatuses) {
        return subscriptionStatusesDAO.save(theSubscriptionStatuses);
    }

    @Override
    public void deleteById(int theId) {
        subscriptionStatusesDAO.deleteById(theId);
    }
}
