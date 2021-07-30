package ch.selise.assessment.service;

import ch.selise.assessment.entity.AccountEntity;
import ch.selise.assessment.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class AccountEntityService {

    private final AccountRepository repository;

    @Transactional
    public Optional<AccountEntity> findByAccountNumber(String accountNumber){
        return repository.findDistinctByAccountNumber(accountNumber);
    }
}
