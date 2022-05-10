package com.example.bankingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingapplication.model.APIResponseModel;
import com.example.bankingapplication.model.CustomerModel;
import com.example.bankingapplication.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@PostMapping("/")
	public APIResponseModel saveCustomer(@RequestBody CustomerModel customerModel) {
		return new APIResponseModel(200, HttpStatus.OK, "Customer Saved..!", customerServiceImpl.saveCustomer(customerModel));
	}
	
	@GetMapping("/")
	public APIResponseModel findAllCustomers() {
		return new APIResponseModel(200, HttpStatus.OK, "Customer List..!", customerServiceImpl.getAllCustomers());
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findCustomerById(@PathVariable Integer id) {
		return new APIResponseModel(200, HttpStatus.OK, "Customer List..!", customerServiceImpl.getCustomerById(id));
	}
}
