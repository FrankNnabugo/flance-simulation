package com.flanceApi.flance.gateway;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PaymentGatewayResolver {

    private final Map<GateWayType, PaymentGateway> gatewayMap;


    public PaymentGatewayResolver(List<PaymentGateway> gatewayList) {
       this.gatewayMap = gatewayList.stream()
                .collect(Collectors.toMap(PaymentGateway::getPaymentGateway, g -> g));
    }


    public PaymentGateway resolve(GateWayType type) {
         PaymentGateway gateway = gatewayMap.get(type);

        if (gateway == null) {
            throw new IllegalArgumentException("Unsupported payment gateway");
        }
        return gateway;
    }
}
