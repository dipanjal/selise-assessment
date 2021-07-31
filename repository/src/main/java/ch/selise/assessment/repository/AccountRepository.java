package ch.selise.assessment.repository;

import ch.selise.assessment.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

/**
 * @author dipanjal
 * @since 0.0.1
 */

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    @Lock(LockModeType.OPTIMISTIC)
    Optional<AccountEntity> findDistinctByAccountNumber(String accountNumber);
}
