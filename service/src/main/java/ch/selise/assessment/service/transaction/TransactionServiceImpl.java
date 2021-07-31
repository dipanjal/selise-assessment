package ch.selise.assessment.service.transaction;

import ch.selise.assessment.model.MessageProperty;
import ch.selise.assessment.model.ValidationResult;
import ch.selise.assessment.model.dto.TransactionRequestDTO;
import ch.selise.assessment.model.request.TransactionRequest;
import ch.selise.assessment.service.TransactionEntityService;
import ch.selise.assessment.service.fundTransfer.FundTransferService;
import ch.selise.assessment.statics.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionModelMapper mapper;
    private final TransactionValidationService validationService;
    private final FundTransferService fundTransferService;
    private final TransactionEntityService transactionEntityService;

    private final MessageProperty property;

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
        fundTransferService.transferFund(result.getSource(), result.getDestination(), dto.getAmount());
        return property.getTransferSuccessful();
    }

    private String reverse(TransactionRequestDTO dto, ValidationResult result) {
        fundTransferService.transferFund(result.getDestination(), result.getSource(), dto.getAmount());
        return property.getReverseSuccessful();
    }

    private void saveTransactionHistory(TransactionRequestDTO dto) {
        transactionEntityService.save(
                mapper.convertToTransactionEntity(dto)
        );
    }

}
