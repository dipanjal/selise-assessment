package ch.selise.assessment.service;

import ch.selise.assessment.entity.TransactionEntity;
import ch.selise.assessment.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author dipanjal
 * @since 0.0.1
 */

@Service
public class TransactionEntityService extends BaseCRUDService<TransactionEntity, TransactionRepository> {

    public TransactionEntityService(TransactionRepository repository) {
        super(repository);
    }

    @Transactional(readOnly = true)
    public Optional<TransactionEntity> findByRequestId(String requestId){
        return repository.findDistinctByRequestId(requestId);
    }
}
