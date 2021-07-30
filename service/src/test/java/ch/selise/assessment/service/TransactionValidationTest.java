package ch.selise.assessment.service;

import ch.selise.assessment.model.dto.TransactionRequestDTO;
import ch.selise.assessment.service.transaction.TransactionValidationService;
import ch.selise.assessment.statics.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@SpringBootTest
public class TransactionValidationTest {

    @Autowired
    TransactionValidationService service;

    @Test
    public void testTransactionValidation(){
        TransactionRequestDTO dto = TransactionRequestDTO
                .builder()
                .sourceAccountNumber("001241009211439")
                .destinationAccountNumber("32341200923487")
                .transactionType(TransactionType.TRANSFER)
                .amount(10000.00)
                .build();
        Assertions.assertNotNull(service.validateTransaction(dto));
    }
}
