package com.example.bankingapplication.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bankingapplication.entity.Customer;
import com.example.bankingapplication.mapper.CustomerAccountMapper;
import com.example.bankingapplication.mapper.CustomerMapper;
import com.example.bankingapplication.model.CustomerModel;
import com.example.bankingapplication.repository.CustomerRepository;
import com.example.bankingapplication.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	
	public CustomerServiceImpl(CustomerRepository customerRepository, 
			CustomerMapper customerMapper, 
			CustomerAccountMapper customerAccountMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}
	
	@Override
	public CustomerModel saveCustomer(CustomerModel customerModel) {
		Customer customer = customerMapper.customerModelToCustomer(customerModel);
		customer = customerRepository.save(customer);
		System.out.println(customer.getId());
		return customerMapper.customerToCustomerModel(customer);
	}
	
	@Override
	public List<CustomerModel> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customerMapper.customerListToCustomerModelList(customers);
	}
	
	@Override
	public CustomerModel getCustomerById(Integer id) {
		return customerMapper.customerToCustomerModel(customerRepository.findById(id).get());
	}
}
