package ch.selise.assessment.service;

import ch.selise.assessment.entity.AccountEntity;
import ch.selise.assessment.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Service
public class AccountEntityService extends BaseCRUDService<AccountEntity, AccountRepository> {

    public AccountEntityService(final AccountRepository repository) {
        super(repository);
    }

    @Transactional(readOnly = true)
    public Optional<AccountEntity> findByAccountNumber(String accountNumber){
        return repository.findDistinctByAccountNumber(accountNumber);
    }
}
