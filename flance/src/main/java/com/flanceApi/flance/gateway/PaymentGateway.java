package com.flanceApi.flance.gateway;

import java.math.BigDecimal;

public interface PaymentGateway {

    void processPayment(String accountNumber, BigDecimal amount);

    GateWayType getPaymentGateway();
}
