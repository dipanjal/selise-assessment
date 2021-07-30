package ch.selise.assessment.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

/**
 * @author dipanjal
 * @since 0.0.1
 */


@Entity
@Table(name = "transaction")
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "request_id", nullable = false, unique = true)
    private String requestId;
    @Column(name = "requester")
    private String requester;
    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "source_account_number")
    private String sourceAccountNumber;
    @Column(name = "amount")
    private double amount;
    @Column(name = "destination_account_number")
    private String destinationAccountNumber;
    @Column(name = "note")
    private String note;
}
