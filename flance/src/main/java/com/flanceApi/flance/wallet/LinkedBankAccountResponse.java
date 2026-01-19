package com.flanceApi.flance.wallet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class LinkedBankAccountResponse {

    private String id;

    private String accountNumber;

    private String accountName;

    private String bankName;

    private Wallet walletId;


}
