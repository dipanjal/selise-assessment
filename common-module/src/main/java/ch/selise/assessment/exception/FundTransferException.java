package ch.selise.assessment.exception;

import lombok.NoArgsConstructor;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@NoArgsConstructor
public class FundTransferException extends RuntimeException {
    public FundTransferException(String message) {
        super(message);
    }

    public FundTransferException(String message, Throwable cause) {
        super(message, cause);
    }
}
