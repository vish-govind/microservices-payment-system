package com.microservices_payment_system.payment_service.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices_payment_system.payment_service.Model.Payment;
import com.microservices_payment_system.payment_service.Repository.PaymentRepository;
import com.microservices_payment_system.payment_service.dto.User;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private PaymentRepository paymentrepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Payment processPayment(String accountNumber , BigDecimal amount) {
		
	 String userServiceUrl = "http://USER-SERVICE/users/" + accountNumber;
	 ResponseEntity<User> response = restTemplate.getForEntity(userServiceUrl, User.class);
	 
	 if(!response.getStatusCode().is2xxSuccessful()||response.getBody() == null)
	 {
		 throw new RuntimeException("User not found!");
	 }
	 
	 User user = response.getBody();
	 
	 if(user.getAccountIsActive() == false)
	 {
		 throw new RuntimeException("Your account is inactive . Activate your account to make payments");
	 }
	 
	 if(user.getAccountBalance().compareTo(amount)<0)
	 {
		 throw new RuntimeException("Balance is insufficient to make a transaction!");
	 }
	 
	 Payment savedPayment = new Payment(accountNumber, amount,"SUCCESS");
			 
          kafkaTemplate.send("payment-topic", "Payment Message: " + savedPayment);
          return paymentrepo.save(savedPayment);
	}

   

}
