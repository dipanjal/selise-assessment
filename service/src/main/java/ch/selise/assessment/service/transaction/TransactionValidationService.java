package ch.selise.assessment.service.transaction;

import ch.selise.assessment.model.ValidationResult;
import ch.selise.assessment.model.dto.TransactionRequestDTO;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public interface TransactionValidationService {
    ValidationResult validateTransaction(TransactionRequestDTO requestDTO);
}
