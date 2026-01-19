package com.flanceApi.flance.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionResponse createTransaction(TransactionRequest request){
        Transactions transactions = Transactions.builder()
                .amount(request.getAmount())
                .wallet(request.getWalletId())
                .status(request.getStatus())
                .build();
        transactionRepository.save(transactions);

        return TransactionResponse.builder()
                .id(transactions.getId())
                .amount(transactions.getAmount())
                .walletId(transactions.getWallet())
                .status(transactions.getStatus())
                .createdAt(transactions.getCreatedAt())
                .build();

    }
}
