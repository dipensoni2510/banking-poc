package com.example.bankingapplication.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.bankingapplication.entity.Customer;
import com.example.bankingapplication.model.CustomerModel;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerModel customerToCustomerModel(Customer customer);
	Customer customerModelToCustomer(CustomerModel customerModel);
	List<CustomerModel> customerListToCustomerModelList(List<Customer> customers);
	
}
