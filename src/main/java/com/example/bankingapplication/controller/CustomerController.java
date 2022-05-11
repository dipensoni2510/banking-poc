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
import com.example.bankingapplication.model.CustomerModel;
import com.example.bankingapplication.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private static final String CUSTOMER_CREATED = "Customer Saved..!";
	private static final String CUSTOMER_LIST = "Customer List..!";
	private static final String CUSTOMER_RECEIVED = "Customer Is Available..!";
	private static final String EXCEPTION = "Something went wrong.";
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/")
	public APIResponseModel saveCustomer(@RequestBody CustomerModel customerModel) {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, CUSTOMER_CREATED, customerService.saveCustomer(customerModel));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
	
	@GetMapping("/")
	public APIResponseModel findAllCustomers() {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, CUSTOMER_LIST, customerService.getAllCustomers());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findCustomerById(@PathVariable Integer id) {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, CUSTOMER_RECEIVED, customerService.getCustomerById(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
}
