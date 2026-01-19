package com.flanceApi.flance.transaction;

import com.flanceApi.flance.wallet.Wallet;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private String id;

    private BigDecimal amount;

    private Wallet walletId;

    private TransactionStatus status;

    private LocalDateTime createdAt;
}
