package com.microservices_payment_system.user_service.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservices_payment_system.user_service.Repository.UserRepository;
import com.microservices_payment_system.user_service.model.User;

@Service
public class UserServiceImpl implements UserService{
	

	private UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User createUser(User user) {
		
		return userRepo.save(user);
		
	}

	@Override
	public User updateUser(String accountNumber, User userDetails) 
	{
	Optional<User> checkUserExists = userRepo.findByAccountNumber(accountNumber);
	
	if(checkUserExists.isPresent()) {
		
	User existing_user = checkUserExists.get();
	
	if (userDetails.getAccountNumber() != null && !userDetails.getAccountNumber().equals(existing_user.getAccountNumber())) {
        throw new IllegalArgumentException("Account number cannot be updated.");
    }

   
    if (userDetails.getAccountType() != null && !userDetails.getAccountType().equals(existing_user.getAccountType())) {
        throw new IllegalArgumentException("Account type cannot be updated.");
    }
	
		if (userDetails.getName() != null) 
		existing_user.setName(userDetails.getName());
	    
		
	    if (userDetails.getEmail() != null) 
	    existing_user.setEmail(userDetails.getEmail());
	    
	    
	    if (userDetails.getAccountBalance() != null) 
	    existing_user.setAccountBalance(userDetails.getAccountBalance());
	    
	    
	    if (userDetails.getAccountOpenDate() != null) 
	    existing_user.setAccountOpenDate(userDetails.getAccountOpenDate());
	    
	    if (userDetails.getPhoneNumber() != null) 
		existing_user.setPhoneNumber(userDetails.getPhoneNumber());
	    
	    return userRepo.save(existing_user);
	}
	else
		throw new RuntimeException("User not found with account number: " + accountNumber);
	}

	@Override
	public String deleteUser(String accountNumber) {
		
		 userRepo.deleteByAccountNumber(accountNumber);
		 return "Success";
	}
}
