package com.microservices_payment_system.user_service.Service;

import com.microservices_payment_system.user_service.model.User;

public interface UserService {

	User createUser(User user);
	
	
	User updateUser(String accountNumber, User user);


	String deleteUser(String accountNumber);
	
}
