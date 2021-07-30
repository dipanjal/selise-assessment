package ch.selise.assessment.service.transaction;

import ch.selise.assessment.model.dto.TransactionRequestDTO;
import ch.selise.assessment.model.request.TransactionRequest;
import org.springframework.stereotype.Component;

import static ch.selise.assessment.utils.Base64Utils.decodeToString;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Component
public class TransactionModelMapper {

    public TransactionRequestDTO convertToDto(TransactionRequest request){
        return TransactionRequestDTO.builder()
                .requestId(request.getRequestId())
                .requester(request.getRequester())
                .transactionType(decodeToString(request.getTransactionType()))
                .sourceAccountNumber(decodeToString(request.getSourceAccountNumber()))
                .amount(Double.parseDouble(decodeToString(request.getAmount())))
                .destinationAccountNumber(decodeToString(request.getDestinationAccountNumber()))
                .note(request.getNote())
                .build();
    }
}
