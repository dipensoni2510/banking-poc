package com.example.bankingapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bankingapplication.entity.CustomerAccount;
import com.example.bankingapplication.mapper.CustomerAccountMapper;
import com.example.bankingapplication.model.CustomerAccountModel;
import com.example.bankingapplication.repository.CustomerAccountRepository;

@Service
public class CustomerAccountServiceImpl {

	private final CustomerAccountRepository customerAccountRepository;
	private final CustomerAccountMapper customerAccountMapper;
	
	public CustomerAccountServiceImpl(CustomerAccountRepository customerAccountRepository, CustomerAccountMapper customerAccountMapper) {
		this.customerAccountRepository = customerAccountRepository;
		this.customerAccountMapper = customerAccountMapper;
	}
	
	public CustomerAccountModel saveCustomerAccount(CustomerAccountModel customerAccountModel) {
		CustomerAccount customerAccount = customerAccountMapper.customerAccountModelToCustomerAccount(customerAccountModel);
//		customerAccount.setAccountNumber(customerAccountModel.getAccountNumber());
//		customerAccount.setBranch(customerAccountModel.getBranch());
//		customerAccount.setAccountBalance(customerAccountModel.getAccountBalance());
//		customerAccount.setAccountType(customerAccountModel.getAccountType());
//		customerAccount.setAccountStatus(customerAccountModel.getAccountStatus());
//		customerAccount.setCustomer(customerAccountModel.getCustomer());
		customerAccount = customerAccountRepository.save(customerAccount);
		return customerAccountMapper.customerAccountTocustomerAccountModel(customerAccount);
	}
	
	public List<CustomerAccountModel> getAllCustomerAccounts() {
		return customerAccountMapper.customerAccountToCustomerAccountModel(customerAccountRepository.findAll());
	}
	
	public CustomerAccountModel getCustomerAccountById(Integer id) {
		return customerAccountMapper.customerAccountTocustomerAccountModel(customerAccountRepository.findById(id).get());
	}
}
