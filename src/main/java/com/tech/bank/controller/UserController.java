package com.tech.bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.bank.dto.Bank;
import com.tech.bank.dto.MockBankData;
import com.tech.bank.exception.UserNotFoundException;
import com.tech.bank.model.User;
import com.tech.bank.repo.UserRepository;

/**
 * Created by Aditya.
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/users/{id}")
	public User getuserById(@PathVariable(value = "id") Long userId) throws Exception {
		return userRepository.findById(userId).orElseThrow(() -> new Exception("User not found with Id: " + userId));
	}

	@GetMapping("/users/banks")
	public List<Bank> getAllBanks(@RequestHeader(value = "name") String name,
			@RequestHeader(value = "password") String password) throws Exception {
		List<Bank> banks = new ArrayList<>();
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		List<User> allUsers = userRepository.findAll();
		if (allUsers.contains(user)) {
			Set<Bank> allBankData = MockBankData.allBankData();
			banks.addAll(allBankData);

		}
		return banks;
	}
	
	@GetMapping("/users/banks/detail")
	public List<Bank> getUserSpecificBank(@RequestHeader(value = "name") String name,
			@RequestHeader(value = "password") String password) throws Exception {
		List<Bank> banks = new ArrayList<>();
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		List<User> allUsers = userRepository.findAll();
		if (allUsers.contains(user)) {
			Set<Bank> allBankData = MockBankData.allBankData();
			for (Bank bank : allBankData) {
				if (bank.getUsers().contains(user)) {
					banks.add(bank);
				}
			}

		} else {
			throw new UserNotFoundException("Invalid User");
		}
		return banks;
	}

}
