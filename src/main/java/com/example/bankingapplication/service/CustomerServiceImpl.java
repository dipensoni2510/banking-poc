package com.example.bankingapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bankingapplication.entity.Customer;
import com.example.bankingapplication.mapper.CustomerAccountMapper;
import com.example.bankingapplication.mapper.CustomerMapper;
import com.example.bankingapplication.model.CustomerModel;
import com.example.bankingapplication.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	private final CustomerAccountMapper customerAccountMapper;
	
	public CustomerServiceImpl(CustomerRepository customerRepository, 
			CustomerMapper customerMapper, 
			CustomerAccountMapper customerAccountMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
		this.customerAccountMapper = customerAccountMapper;
	}
	
	public CustomerModel saveCustomer(CustomerModel customerModel) {
		Customer customer = customerMapper.customerModelToCustomer(customerModel);
		customer = customerRepository.save(customer);
		return customerMapper.customerToCustomerModel(customer);
	}
	
	public List<CustomerModel> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customerMapper.customerListToCustomerModelList(customers);
	}
	
	public CustomerModel getCustomerById(Integer id) {
		return customerMapper.customerToCustomerModel(customerRepository.findById(id).get());
	}
}
