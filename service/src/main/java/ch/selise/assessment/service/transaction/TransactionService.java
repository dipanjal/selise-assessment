package ch.selise.assessment.service.transaction;

import ch.selise.assessment.model.request.TransactionRequest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public interface TransactionService {
    @Transactional(rollbackFor = Exception.class)
    String transaction(TransactionRequest request);
}
