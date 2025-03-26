package com.microservices_payment_system.user_service.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	
	@Column(unique = true, nullable = false)
	private String accountNumber;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	private BigDecimal accountBalance;
	    
	private LocalDate accountOpenDate;
	
	private boolean accountIsActive;
	
	

	 public User() {
		super();
		// TODO Auto-generated constructor stub
	   }



	public User(Long id, String name, String email, String phoneNumber, String accountNumber, AccountType accountType,
			BigDecimal accountBalance, LocalDate accountOpenDate, boolean accountIsActive) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountOpenDate = accountOpenDate;
		this.accountIsActive = accountIsActive;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public BigDecimal getAccountBalance() {
		return accountBalance;
	}



	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}



	public LocalDate getAccountOpenDate() {
		return accountOpenDate;
	}



	public void setAccountOpenDate(LocalDate accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}



	public boolean isAccountIsActive() {
		return accountIsActive;
	}



	public void setAccountIsActive(boolean accountIsActive) {
		this.accountIsActive = accountIsActive;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public AccountType getAccountType() {
		return accountType;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", accountOpenDate=" + accountOpenDate + ", accountIsActive=" + accountIsActive
				+ "]";
	}	
	
}
