package com.flanceApi.flance.wallet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallets")
public class WalletController {

    WalletService walletService;

    @PostMapping
    public ResponseEntity<WalletResponse> createWallet(@RequestBody WalletRequest request){
        WalletResponse response = walletService.createWallet(request);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{emailAddress}")
    public ResponseEntity<Wallet> findWalletByEmail(@PathVariable("emailAddress") String emailAddress){
        Wallet wallet = walletService.findWalletByEmail(emailAddress);
        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<List<LinkedBankAccountResponse>> getLinkedBanks(@PathVariable String walletId){

        List<LinkedBankAccountResponse> banks = walletService.getLinkedBanks(walletId);

        return ResponseEntity.ok(banks);

    }

    @PostMapping("/{walletId}/fund/bank")
    public ResponseEntity<String> fundWallet(@PathVariable String walletId, @RequestBody FundWalletRequest request) {
        String response = walletService.fundWallet(walletId, request);
        return ResponseEntity.ok(response);
    }
}
