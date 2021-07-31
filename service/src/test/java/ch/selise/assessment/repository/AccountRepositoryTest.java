package ch.selise.assessment.repository;

import ch.selise.assessment.service.AccountEntityService;
import ch.selise.assessment.entity.AccountEntity;
import ch.selise.assessment.exception.RecordNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private AccountEntityService service;

    @Test
    public void testFindByAccountNumber(){
        String accountNumber = "32341200923487";
        AccountEntity entity = service
                .findByAccountNumber(accountNumber)
                .orElseThrow(RecordNotFoundException::new);
        Assertions.assertNotNull(entity);
    }
}
