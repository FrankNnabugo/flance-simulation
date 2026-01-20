package com.flanceApi.flance.wallet;

import com.flanceApi.flance.account.BankAccountRepository;
import com.flanceApi.flance.account.BankAccounts;
import com.flanceApi.flance.gateway.PaymentGateway;
import com.flanceApi.flance.gateway.PaymentGatewayResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletService {

    private final WalletRepository walletRepository;
    private final BankAccountRepository bankAccountRepository;
    private final PaymentGatewayResolver paymentGatewayResolver;

    public WalletResponse createWallet(WalletRequest request){

               Wallet wallet = Wallet.builder()
               .emailAddress(request.getEmailAddress())
               .phoneNumber(request.getPhoneNumber())
               .build();
               walletRepository.save(wallet);

               return WalletResponse.builder()
                       .emailAddress(wallet.getEmailAddress())
                       .phoneNumber(wallet.getPhoneNumber())
                       .build();
    }


    public Wallet findWalletByEmail(String emailAddress){

        Wallet wallet = walletRepository.findByEmailAddress(emailAddress);
        if(wallet == null){
            throw new RuntimeException("Wallet not found");
        }

        return Wallet.builder()
                .id(wallet.getId())
                .emailAddress(wallet.getEmailAddress())
                .phoneNumber(wallet.getPhoneNumber())
                .balance(wallet.getBalance())
                .createdAt(wallet.getCreatedAt())
                .updatedAt(wallet.getUpdatedAt())
                .build();
    }

    public List<LinkedBankAccountResponse> getLinkedBanks(String walletId){

        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));


        return bankAccountRepository.findByWallet_Id(wallet.getId())
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private LinkedBankAccountResponse mapToResponse(BankAccounts bank) {
        return LinkedBankAccountResponse.builder()
                .id(bank.getId())
                .accountNumber(bank.getAccountNumber())
                .accountName(bank.getAccountName())
                .bankName(bank.getBankName())
                .build();
    }

    public String fundWallet(String walletId, FundWalletRequest request){

        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));


        BankAccounts bank = bankAccountRepository.findByWalletIdAndAccountNumber(walletId, request.getAccountNumber())
                .orElseThrow(()-> new RuntimeException("Bank account not linked to wallet"));

        PaymentGateway gateway =
                paymentGatewayResolver.resolvePaymentGateway(request.getPaymentGateWay());

        gateway.processPayment(request.getAccountNumber(), request.getAmount());

        //Credit wallet and update wallet state
        //Create transaction
        //create ledger

        return "Wallet funding successfully processed";
    }
}
