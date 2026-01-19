package com.flanceApi.flance.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class PaystackGateWay implements PaymentGateway{

    @Override
    public void processPayment(String accountNumber, BigDecimal amount){
        log.info("Simulating Paystack payment for account {} amount {}",
                accountNumber, amount);
    }

    @Override
    public GateWayType getPaymentGateway(){
        return GateWayType.PAY_STACK;

    }
}
