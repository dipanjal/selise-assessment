package ch.selise.assessment.service.transaction;

import ch.selise.assessment.model.MessageProperty;
import ch.selise.assessment.service.AccountEntityService;
import ch.selise.assessment.entity.AccountEntity;
import ch.selise.assessment.exception.TransactionException;
import ch.selise.assessment.exception.InvalidArgumentException;
import ch.selise.assessment.exception.RecordNotFoundException;
import ch.selise.assessment.model.ValidationResult;
import ch.selise.assessment.model.dto.TransactionRequestDTO;
import ch.selise.assessment.service.TransactionEntityService;
import ch.selise.assessment.statics.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class TransactionValidationServiceImpl implements TransactionValidationService {

    private final AccountEntityService accountEntityService;
    private final TransactionEntityService transactionEntityService;
    private final MessageProperty property;

    @Override
    public ValidationResult validateTransaction(TransactionRequestDTO requestDTO) {

        if(TransactionType.isNotValid(requestDTO.getTransactionType()))
            throw new InvalidArgumentException(property.getInvalidTransactionTypeError());

        this.checkUniqueRequestId(requestDTO.getRequestId());

        AccountEntity source = accountEntityService
                .findByAccountNumber(requestDTO.getSourceAccountNumber())
                .orElseThrow(() -> new RecordNotFoundException(property.getSourceAccNotFoundError()));

        AccountEntity destination = accountEntityService
                .findByAccountNumber(requestDTO.getDestinationAccountNumber())
                .orElseThrow(() -> new RecordNotFoundException(property.getDestinationAccNotFoundError()));

        validateBalanceEligibility(source, destination, requestDTO.getTransactionType(), requestDTO.getAmount());

        return new ValidationResult(source, destination, true);
    }

    private void validateBalanceEligibility(AccountEntity source,
                                               AccountEntity destination,
                                               String type, double amount) {
        if(TransactionType.isTransfer(type))
            checkAccountBalance(source, amount);
        else
            checkAccountBalance(destination, amount);
    }

    private void checkAccountBalance(AccountEntity senderAccount, double amount){
        if(senderAccount.getBalance() < amount)
            throw new TransactionException(property.getInsufficientBalanceError());
    }

    private void checkUniqueRequestId(String requestId){

        transactionEntityService.findByRequestId(requestId)
                .ifPresent(t -> {
                    throw new InvalidArgumentException(property.getRequestIdDuplicateError());
                });
    }
}
