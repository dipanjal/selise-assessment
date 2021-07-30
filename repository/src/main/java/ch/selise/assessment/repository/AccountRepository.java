package ch.selise.assessment.repository;

import ch.selise.assessment.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author dipanjal
 * @since 0.0.1
 */

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findDistinctByAccountNumber(String accountNumber);
}
