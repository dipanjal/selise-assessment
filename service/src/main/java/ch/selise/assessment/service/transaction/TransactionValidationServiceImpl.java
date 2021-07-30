package ch.selise.assessment.service.transaction;

import ch.selise.assessment.service.AccountEntityService;
import ch.selise.assessment.entity.AccountEntity;
import ch.selise.assessment.exception.FundTransferException;
import ch.selise.assessment.exception.InvalidArgumentException;
import ch.selise.assessment.exception.RecordNotFoundException;
import ch.selise.assessment.model.ValidationResult;
import ch.selise.assessment.model.dto.TransactionRequestDTO;
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

    @Override
    public ValidationResult validateTransaction(TransactionRequestDTO requestDTO) {

        if(TransactionType.isNotValid(requestDTO.getTransactionType()))
            throw new InvalidArgumentException("Invalid Transaction Type");

        AccountEntity source = accountEntityService
                .findByAccountNumber(requestDTO.getSourceAccountNumber())
                .orElseThrow(() -> new RecordNotFoundException("Source Account Not Found"));

        AccountEntity destination = accountEntityService
                .findByAccountNumber(requestDTO.getDestinationAccountNumber())
                .orElseThrow(() -> new RecordNotFoundException("Destination Account Not Found"));

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
            throw new FundTransferException("Insufficient Balance");
    }
}
