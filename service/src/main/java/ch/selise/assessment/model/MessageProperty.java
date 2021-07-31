package ch.selise.assessment.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Component
@ConfigurationProperties("message-property")
@Getter
@Setter
public class MessageProperty {
    private String transferSuccessful;
    private String reverseSuccessful;
    private String invalidTransactionTypeError;
    private String sourceAccNotFoundError;
    private String destinationAccNotFoundError;
    private String insufficientBalanceError;
    private String requestIdDuplicateError;
}
