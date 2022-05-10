package com.example.bankingapplication.service;

import java.util.List;

import com.example.bankingapplication.model.CustomerAccountModel;

public interface CustomerAccountService {

	CustomerAccountModel saveCustomerAccount(CustomerAccountModel customerAccountModel);

	List<CustomerAccountModel> getAllCustomerAccounts();

	CustomerAccountModel getCustomerAccountById(Integer id);

}
