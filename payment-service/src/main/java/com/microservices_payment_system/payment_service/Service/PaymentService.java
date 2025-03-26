package com.microservices_payment_system.payment_service.Service;

import java.math.BigDecimal;

import com.microservices_payment_system.payment_service.Model.Payment;

public interface PaymentService {
	
	 public Payment processPayment(String accountNumber , BigDecimal amount);

}
