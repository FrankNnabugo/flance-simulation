package com.flanceApi.flance.wallet;


import com.flanceApi.flance.gateway.GateWayType;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FundWalletRequest {

    private String accountNumber;

    private BigDecimal amount;

    private GateWayType paymentGateWay;

}
