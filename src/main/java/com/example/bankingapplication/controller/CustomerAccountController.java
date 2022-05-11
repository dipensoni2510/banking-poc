package com.example.bankingapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.bankingapplication.service.CustomerAccountService;

@RestController
@RequestMapping("/customer-accounts")
public class CustomerAccountController {

	private static final String CUSTOMER_ACCOUNT_CREATED = "Customer Account Saved..!";
	private static final String CUSTOMER_ACCOUNT_LIST = "Customer Account Saved..!";
	private static final String CUSTOMER_ACCOUNT_RECEIVED = "Customer Account Is Available..!";
	private static final String EXCEPTION = "Something went wrong.";
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerAccountController.class);
	
	@Autowired
	private CustomerAccountService customerAccountService;
	
	@PostMapping("/")
	public APIResponseModel saveCustomerAccount(@RequestBody CustomerAccountModel customerAccountModel) {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, CUSTOMER_ACCOUNT_CREATED, customerAccountService.saveCustomerAccount(customerAccountModel));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
	
	@GetMapping("/")
	public APIResponseModel findAllCustomerAccounts() {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, CUSTOMER_ACCOUNT_LIST, customerAccountService.getAllCustomerAccounts());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findCustomerAccountById(@PathVariable Integer id) {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, CUSTOMER_ACCOUNT_RECEIVED, customerAccountService.getCustomerAccountById(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
}
