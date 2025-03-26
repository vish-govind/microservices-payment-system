package com.microservices_payment_system.payment_service.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices_payment_system.payment_service.Model.Payment;
import com.microservices_payment_system.payment_service.Service.PaymentServiceImpl;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	 @Autowired
	 private PaymentServiceImpl paymentService;
	 
	 @PostMapping
	 public ResponseEntity<Payment> processPayment(@RequestParam String accountNumber, @RequestParam BigDecimal amount)
	 {
	   Payment payment =  paymentService.processPayment(accountNumber, amount);
	   return  ResponseEntity.ok(payment);
	  
	 }

}
