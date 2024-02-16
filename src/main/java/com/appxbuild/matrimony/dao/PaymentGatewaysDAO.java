package com.appxbuild.matrimony.dao;

import com.appxbuild.matrimony.entity.PaymentGateways;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentGatewaysDAO extends JpaRepository<PaymentGateways, Integer> {
}
