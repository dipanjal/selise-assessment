package ch.selise.assessment.service.fundTransfer;

import ch.selise.assessment.entity.AccountEntity;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public interface FundTransferService {
    void transferFund(AccountEntity source, AccountEntity destination, double amount);
    void withdraw(AccountEntity account, double amount);
    void deposit(AccountEntity account, double amount);
}
