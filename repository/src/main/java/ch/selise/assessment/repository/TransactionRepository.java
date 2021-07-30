package ch.selise.assessment.repository;

import ch.selise.assessment.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Optional<TransactionEntity> findDistinctByRequestId(String requestId);
}
