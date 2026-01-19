package com.flanceApi.flance.account;

import com.flanceApi.flance.wallet.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    private final WalletRepository walletRepository;

    public BankResponse linkBankAccount(String walletId, BankAccountRequest request){
        walletRepository.findById(walletId).orElseThrow(()->
                new RuntimeException("Wallet not found"));

        if(bankAccountRepository.existsByAccountNumber(request.getAccountNumber())){
            throw new RuntimeException("Bank account already linked");
        }

       BankAccounts account = BankAccounts.builder()
                .accountName(request.getAccountName())
                .accountNumber(request.getAccountNumber())
                .bankName(request.getBankName())
                .build();
        bankAccountRepository.save(account);

        return BankResponse.builder()
                .accountName(account.getBankName())
                .accountNumber(account.getAccountNumber())
                .bankName(account.getBankName())
                .build();
    }

}
