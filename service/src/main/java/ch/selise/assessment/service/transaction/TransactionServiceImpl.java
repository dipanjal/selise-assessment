package ch.selise.assessment.service.transaction;

import ch.selise.assessment.entity.AccountEntity;
import ch.selise.assessment.entity.TransactionEntity;
import ch.selise.assessment.model.ValidationResult;
import ch.selise.assessment.model.dto.TransactionRequestDTO;
import ch.selise.assessment.model.request.TransactionRequest;
import ch.selise.assessment.service.AccountEntityService;
import ch.selise.assessment.service.TransactionEntityService;
import ch.selise.assessment.statics.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionModelMapper mapper;
    private final TransactionValidationService validationService;
    private final AccountEntityService entityService;
    private final TransactionEntityService transactionEntityService;

    @Override
    public String transaction(TransactionRequest request) {

        TransactionRequestDTO dto = mapper.convertToDto(request);

        ValidationResult result = validationService.validateTransaction(dto);

        String responseMessage = TransactionType.isTransfer(dto.getTransactionType())
                ? transfer(dto, result)
                : reverse(dto, result);

        this.saveTransactionHistory(dto);

        return responseMessage;
    }

    private String transfer(TransactionRequestDTO dto, ValidationResult result) {
        this.debitCredit(result.getSource(), result.getDestination(), dto.getAmount());
        return "Transaction Successful";
    }

    private String reverse(TransactionRequestDTO dto, ValidationResult result) {
        this.debitCredit(result.getDestination(), result.getSource(), dto.getAmount());
        return "Reverse Successful";
    }

    private void debitCredit(AccountEntity source, AccountEntity destination, double amount){
        source.setBalance(source.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);
        entityService.save(List.of(source, destination));
    }

    private void saveTransactionHistory(TransactionRequestDTO dto) {
        TransactionEntity entity = mapper.convertToTransactionEntity(dto);
        transactionEntityService.save(entity);
    }

}
