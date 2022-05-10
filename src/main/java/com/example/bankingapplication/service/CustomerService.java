package com.example.bankingapplication.service;

import java.util.List;

import com.example.bankingapplication.model.CustomerModel;

public interface CustomerService {

	CustomerModel saveCustomer(CustomerModel customerModel);

	List<CustomerModel> getAllCustomers();

	CustomerModel getCustomerById(Integer id);

}
