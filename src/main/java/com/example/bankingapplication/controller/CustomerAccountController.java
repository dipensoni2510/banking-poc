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
import com.example.bankingapplication.model.CustomerAccountModel;
import com.example.bankingapplication.serviceimpl.CustomerAccountServiceImpl;

@RestController
@RequestMapping("/customer-accounts")
public class CustomerAccountController {

	@Autowired
	private CustomerAccountServiceImpl customerAccountServiceImpl;
	
	@PostMapping("/")
	public APIResponseModel saveCustomerAccount(@RequestBody CustomerAccountModel customerAccountModel) {
		return new APIResponseModel(200, HttpStatus.OK, "Customer Account Saved..!", customerAccountServiceImpl.saveCustomerAccount(customerAccountModel));
	}
	
	@GetMapping("/")
	public APIResponseModel findAllCustomerAccounts() {
		return new APIResponseModel(200, HttpStatus.OK, "Customer Account Listing..!", customerAccountServiceImpl.getAllCustomerAccounts());
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findCustomerAccountById(@PathVariable Integer id) {
		return new APIResponseModel(200, HttpStatus.OK, "Customer Account Is Available..!", customerAccountServiceImpl.getCustomerAccountById(id));
	}
}
