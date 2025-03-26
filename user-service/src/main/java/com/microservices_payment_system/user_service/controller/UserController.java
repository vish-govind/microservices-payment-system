package com.microservices_payment_system.user_service.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices_payment_system.user_service.Service.UserService;
import com.microservices_payment_system.user_service.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService usersvc;

	public UserController(UserService usersvc) {
		super();
		this.usersvc = usersvc;
	}
	
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return usersvc.createUser(user);
		
	}
	
	@PutMapping("/{accountNumber}")
	public User updateUser(@PathVariable String accountNumber , @RequestBody User user )
	{
		return usersvc.updateUser(accountNumber,user);
		
	}
	
	@DeleteMapping
	public String deleteUserDetails(@PathVariable String accountNumber)
	{
		return usersvc.deleteUser(accountNumber);
	}
}
