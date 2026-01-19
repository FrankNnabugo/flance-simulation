package com.flanceApi.flance.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccounts, String> {
    boolean existsByAccountNumber(String accountNumber);
    List<BankAccounts> findByWallet_Id(String walletId);
    Optional<BankAccounts> findByWalletIdAndAccountNumber(String walletId, String accountNumber);
}
