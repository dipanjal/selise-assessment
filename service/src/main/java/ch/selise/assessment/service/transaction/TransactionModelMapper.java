package ch.selise.assessment.service.transaction;

import ch.selise.assessment.entity.TransactionEntity;
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

    public TransactionEntity convertToTransactionEntity(TransactionRequestDTO dto){
        TransactionEntity entity = new TransactionEntity();
        entity.setRequestId(dto.getRequestId());
        entity.setRequester(dto.getRequester());
        entity.setTransactionType(dto.getTransactionType());
        entity.setSourceAccountNumber(dto.getSourceAccountNumber());
        entity.setAmount(dto.getAmount());
        entity.setDestinationAccountNumber(dto.getDestinationAccountNumber());
        entity.setNote(dto.getNote());
        return entity;
    }
}
