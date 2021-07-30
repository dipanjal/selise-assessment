package ch.selise.assessment.service.transaction;

import ch.selise.assessment.model.request.TransactionRequest;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public interface TransactionService {

    String transaction(TransactionRequest request);
}
