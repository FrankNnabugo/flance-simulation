package com.flanceApi.flance.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bankAccounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping("/{walletId}")
    public ResponseEntity<BankResponse> linkBankAccount(@PathVariable String walletId,
                                                        @RequestBody BankAccountRequest request){
        BankResponse response = bankAccountService.linkBankAccount(walletId, request);
        return ResponseEntity.ok(response);

    }


}
