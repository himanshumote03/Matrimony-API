package com.appxbuild.matrimony.service;

import com.appxbuild.matrimony.entity.PaymentGateways;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentGatewaysService {

    List<PaymentGateways> findAll();
    PaymentGateways findById(int theId);
    PaymentGateways save(PaymentGateways paymentGateways);
    void deleteById(int theId);
}
