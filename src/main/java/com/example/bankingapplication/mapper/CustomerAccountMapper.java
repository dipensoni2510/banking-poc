package com.example.bankingapplication.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.bankingapplication.entity.CustomerAccount;
import com.example.bankingapplication.model.CustomerAccountModel;

@Mapper(componentModel = "spring")
public interface CustomerAccountMapper {

	CustomerAccountModel customerAccountTocustomerAccountModel(CustomerAccount customerAccount);
	CustomerAccount customerAccountModelToCustomerAccount(CustomerAccountModel customerAccountModel);
	List<CustomerAccountModel> customerAccountToCustomerAccountModel(List<CustomerAccount> customerAccounts);
	
}
