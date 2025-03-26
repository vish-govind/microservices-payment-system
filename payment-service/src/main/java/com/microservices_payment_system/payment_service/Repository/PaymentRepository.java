package com.microservices_payment_system.payment_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices_payment_system.payment_service.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

	
}
