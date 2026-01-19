package com.flanceApi.flance.wallet;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletRequest {

    private String emailAddress;

    private String phoneNumber;
}
