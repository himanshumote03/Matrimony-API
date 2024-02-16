package com.appxbuild.matrimony.rest;


import com.appxbuild.matrimony.entity.PaymentGateways;
import com.appxbuild.matrimony.service.PaymentGatewaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentGatewaysRestController {

    private PaymentGatewaysService paymentGatewaysService;

    @Autowired
    public PaymentGatewaysRestController(PaymentGatewaysService thePaymentGatewaysService){
        paymentGatewaysService = thePaymentGatewaysService;
    }

    // expose GET "/paymentGateways" to get a list of paymentGateways
    @GetMapping("/paymentGateways")
    public List<PaymentGateways> findAll(){
        return paymentGatewaysService.findAll();
    }

    // add mapping for GET "/paymentGateways/{paymentGatewaysId}" to get paymentGateway
    @GetMapping("/paymentGateways/{paymentGatewaysId}")
    public PaymentGateways getById(@PathVariable int paymentGatewaysId){
        PaymentGateways thePaymentGateways = paymentGatewaysService.findById(paymentGatewaysId);
        if(thePaymentGateways == null){
            throw new RuntimeException("Payment Gateway id is  not found " + paymentGatewaysId);
        }
        return thePaymentGateways;
    }

    // add mapping for POST "/paymentGateways" to add new paymentGateway
    @PostMapping("/paymentGateways")
    public PaymentGateways addPaymentGateway(@RequestBody PaymentGateways thePaymentGateways){
        thePaymentGateways.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        thePaymentGateways.setCreated(localDateTime);
        thePaymentGateways.setModified(null);
        PaymentGateways newPaymentGateways = paymentGatewaysService.save(thePaymentGateways);
        return newPaymentGateways;
    }

    // add mapping for PUT "/paymentGateways" to update paymentGateway
    @PutMapping("/paymentGateways")
    public PaymentGateways updatePaymentGateway(@RequestBody PaymentGateways thePaymentGateways){
        LocalDateTime localDateTime = LocalDateTime.now();
        thePaymentGateways.setModified(localDateTime);
        PaymentGateways newPaymentGateways = paymentGatewaysService.save(thePaymentGateways);
        return newPaymentGateways;
    }

    // add mapping for GET "/paymentGateways/{paymentGatewaysId}" to get paymentGateway
    @DeleteMapping("/paymentGateways/{paymentGatewaysId}")
    public String deleteById(@PathVariable int paymentGatewaysId){
        PaymentGateways thePaymentGateways = paymentGatewaysService.findById(paymentGatewaysId);
        paymentGatewaysService.deleteById(paymentGatewaysId);
        if(thePaymentGateways == null){
            throw new RuntimeException("Payment Gateway id is  not found " + paymentGatewaysId);
        }
        return "deleted Payment Gateway id " + paymentGatewaysId;
    }
}
