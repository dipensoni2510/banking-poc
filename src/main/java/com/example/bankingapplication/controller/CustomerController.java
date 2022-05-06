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

import com.example.bankingapplication.model.CustomerModel;
import com.example.bankingapplication.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<CustomerModel> saveCustomer(@RequestBody CustomerModel customerModel) {
		return ResponseEntity.ok(customerServiceImpl.saveCustomer(customerModel));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CustomerModel>> findAllCustomers() {
		return ResponseEntity.ok(customerServiceImpl.getAllCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerModel> findCustomerById(@PathVariable Integer id) {
		return ResponseEntity.ok(customerServiceImpl.getCustomerById(id));
	}
}
