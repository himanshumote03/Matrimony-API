package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.dao.PaymentGatewaysDAO;
import com.appxbuild.matrimony.entity.PaymentGateways;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PaymentGatewaysServiceImpl implements PaymentGatewaysService{

    private PaymentGatewaysDAO paymentGatewaysDAO;

    @Autowired
    public PaymentGatewaysServiceImpl(PaymentGatewaysDAO thePaymentGatewaysDAO){
        paymentGatewaysDAO = thePaymentGatewaysDAO;
    }

    @Override
    public List<PaymentGateways> findAll() {
        return paymentGatewaysDAO.findAll();
    }

    @Override
    public PaymentGateways findById(int theId) {
        Optional<PaymentGateways> result = paymentGatewaysDAO.findById(theId);
        PaymentGateways thePaymentGateways = null;
        if(result.isPresent()){
            thePaymentGateways = result.get();
        }
        else {
            throw new RuntimeException("Payment Gateway id is not found " + theId);
        }
        return thePaymentGateways;
    }

    @Override
    public PaymentGateways save(PaymentGateways paymentGateways) {
        return paymentGatewaysDAO.save(paymentGateways);
    }

    @Override
    public void deleteById(int theId) {
        paymentGatewaysDAO.deleteById(theId);
    }
}
