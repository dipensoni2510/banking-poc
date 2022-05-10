package com.example.bankingapplication.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bankingapplication.entity.CustomerAccount;
import com.example.bankingapplication.mapper.CustomerAccountMapper;
import com.example.bankingapplication.model.CustomerAccountModel;
import com.example.bankingapplication.repository.CustomerAccountRepository;
import com.example.bankingapplication.service.CustomerAccountService;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService{

	private final CustomerAccountRepository customerAccountRepository;
	private final CustomerAccountMapper customerAccountMapper;
	
	public CustomerAccountServiceImpl(CustomerAccountRepository customerAccountRepository, CustomerAccountMapper customerAccountMapper) {
		this.customerAccountRepository = customerAccountRepository;
		this.customerAccountMapper = customerAccountMapper;
	}
	
	@Override
	public CustomerAccountModel saveCustomerAccount(CustomerAccountModel customerAccountModel) {
		CustomerAccount customerAccount = customerAccountMapper.customerAccountModelToCustomerAccount(customerAccountModel);
		customerAccount = customerAccountRepository.save(customerAccount);
		return customerAccountMapper.customerAccountTocustomerAccountModel(customerAccount);
	}
	
	@Override
	public List<CustomerAccountModel> getAllCustomerAccounts() {
		return customerAccountMapper.customerAccountToCustomerAccountModel(customerAccountRepository.findAll());
	}
	
	@Override
	public CustomerAccountModel getCustomerAccountById(Integer id) {
		return customerAccountMapper.customerAccountTocustomerAccountModel(customerAccountRepository.findById(id).get());
	}
}
