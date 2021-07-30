package ch.selise.assessment.model;

import ch.selise.assessment.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResult {
    private AccountEntity source;
    private AccountEntity destination;
    boolean success;
}
