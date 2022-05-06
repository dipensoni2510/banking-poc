package com.example.bankingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingapplication.model.CustomerAccountModel;
import com.example.bankingapplication.service.CustomerAccountServiceImpl;

@RestController
@RequestMapping("/customer-accounts")
public class CustomerAccountController {

	@Autowired
	private CustomerAccountServiceImpl customerAccountServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<CustomerAccountModel> saveCustomerAccount(@RequestBody CustomerAccountModel customerAccountModel) {
		return ResponseEntity.ok(customerAccountServiceImpl.saveCustomerAccount(customerAccountModel));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CustomerAccountModel>> findAllCustomerAccounts() {
		return ResponseEntity.ok(customerAccountServiceImpl.getAllCustomerAccounts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerAccountModel> findCustomerAccountById(@PathVariable Integer id) {
		return ResponseEntity.ok(customerAccountServiceImpl.getCustomerAccountById(id));
	}
}
