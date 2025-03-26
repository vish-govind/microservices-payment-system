package com.microservices_payment_system.payment_service.dto;

import java.math.BigDecimal;

public class User {
	
	private String accountNumber;
    private BigDecimal accountBalance;
    private boolean accountIsActive;

    // Constructors
    public User() {}

    public User(String accountNumber, BigDecimal accountBalance, boolean accountIsActive ) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountIsActive = accountIsActive;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

	public boolean getAccountIsActive() {
		return accountIsActive;
	}

	public void setAccountIsActive(boolean accountIsActive) {
		this.accountIsActive = accountIsActive;
	}

}
