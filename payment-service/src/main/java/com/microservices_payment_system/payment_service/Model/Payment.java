package com.microservices_payment_system.payment_service.Model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private String status;

    @Column(name = "transaction_id", unique = true, nullable = false)
    private String transactionId;

   
    public Payment() {
        this.transactionId = UUID.randomUUID().toString();  // Generate unique transaction ID
        this.status = "PENDING";  // Default status
        this.amount = BigDecimal.ZERO;  // Default amount
    }

    
    public Payment(String accountNumber, BigDecimal amount, String status) {
        this.accountNumber = accountNumber;
        this.amount = amount != null ? amount : BigDecimal.ZERO;
        this.status = status != null ? status : "PENDING";
        this.transactionId = UUID.randomUUID().toString();  // Generate unique transaction ID
    }



    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }


	@Override
	public String toString() {
		return "Payment [id=" + id + ", accountNumber=" + accountNumber + ", amount=" + amount + ", status=" + status
				+ ", transactionId=" + transactionId + "]";
	}

}
