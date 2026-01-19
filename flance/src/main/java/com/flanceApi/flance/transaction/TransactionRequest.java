package com.flanceApi.flance.transaction;

import com.flanceApi.flance.wallet.Wallet;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private BigDecimal amount;

    private Wallet walletId;

    private TransactionStatus status;
}
