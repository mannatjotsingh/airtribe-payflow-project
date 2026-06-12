package com.airtribe.payflow.controller;

import com.airtribe.payflow.entity.User;
import com.airtribe.payflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User registerUser(@RequestBody User user) {
		System.out.println("Received User: " + user.getName());
		return userService.registerUser(user);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@GetMapping("/upi/{upiId}")
	public User getUserByUpiId(@PathVariable String upiId) {
		return userService.findByUpiId(upiId);
	}

	@GetMapping("/balance/{amount}")
	public List<User> getUsersByBalance(@PathVariable Double amount) {

		return userService.getUsersWithBalanceGreaterThan(amount);
	}
}