package com.flanceApi.flance.gateway;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private String accountNumber;

    private BigDecimal amount;

}
