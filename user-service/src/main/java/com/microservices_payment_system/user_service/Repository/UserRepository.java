package com.microservices_payment_system.user_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices_payment_system.user_service.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	java.util.Optional<User> findByAccountNumber(String accountNumber);

	String deleteByAccountNumber(String accountNumber);
	

}
