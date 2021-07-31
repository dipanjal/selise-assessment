package ch.selise.assessment.service.fundTransfer;

import ch.selise.assessment.entity.AccountEntity;
import ch.selise.assessment.service.AccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class FundTransferServiceImpl implements FundTransferService{

    private final AccountEntityService entityService;

    @Override
    public void transferFund(AccountEntity source, AccountEntity destination, double amount) {
        this.withdraw(source, amount);
        this.deposit(destination, amount);
    }

    @Override
    public void withdraw(AccountEntity account, double amount) {
        account.setBalance(account.getBalance() - amount);
        entityService.save(account);
    }

    @Override
    public void deposit(AccountEntity account, double amount) {
        account.setBalance(account.getBalance() + amount);
        entityService.save(account);
    }
}
