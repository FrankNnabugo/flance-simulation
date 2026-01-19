package com.flanceApi.flance.account;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequest {

    private String accountNumber;

    private String accountName;

    private String bankName;
}
