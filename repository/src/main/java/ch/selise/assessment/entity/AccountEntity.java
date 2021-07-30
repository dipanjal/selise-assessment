package ch.selise.assessment.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@Entity
@Table(name = "account")
@Data
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "accountNumber", nullable = false, unique = true)
    private String accountNumber;
    @Column(name = "balance", nullable = false)
    private double balance;
    private int status;
}
